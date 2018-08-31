package com.itheima.web.bos.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Region;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.utils.FileUtils;
import com.itheima.web.bos.action.base.BaseAction;

/**
 * 分区管理
 * 
 * @author Dragon
 *
 */
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {

	@Autowired
	private ISubareaService subareaService;

	public SubareaAction() throws InstantiationException, IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 添加分区
	 * 
	 * @return
	 */
	public String addSubarea() {
		subareaService.save(model);
		return LIST;
	}

	/**
	 * 分页查询分区
	 * 
	 * @return
	 */
	public String pageQuery() {
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		String addresskey = model.getAddresskey();
		if (StringUtils.isNotBlank(addresskey)) {
			dc.add(Restrictions.like("addresskey", "%" + addresskey + "%"));
		}
		Region region = model.getRegion();
		dc.createAlias("region", "r");
		if (region != null) {
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			if (StringUtils.isNotBlank(province)) {
				dc.add(Restrictions.like("r.province", "%" + province + "%"));
			}
			if (StringUtils.isNotBlank(city)) {
				dc.add(Restrictions.like("r.city", "%" + city + "%"));
			}
			if (StringUtils.isNotBlank(district)) {
				dc.add(Restrictions.like("r.district", "%" + district + "%"));
			}
		}
		subareaService.pageQuery(pageBean);
		this.javaToJson(pageBean,
				new String[] { "currentPage", "detachedCriteria", "pageSize", "subareas", "decidedzone" });
		return NONE;
	}
	/**
	 * 查询所有分区数据，使用POI将数据写到Excel文件中，使用输出流进行文件下载。
	 * @return
	 * @throws IOException 
	 */
	public String exportXls() throws IOException {
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet("分区数据");
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("开始编号");
		headRow.createCell(2).setCellValue("结束编号");
		headRow.createCell(3).setCellValue("位置信息");
		headRow.createCell(4).setCellValue("省市区");
		List<Subarea> subareaList = subareaService.findaAll();
		for (Subarea subarea : subareaList) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getStartnum());
			dataRow.createCell(2).setCellValue(subarea.getEndnum());
			dataRow.createCell(3).setCellValue(subarea.getPosition());
			dataRow.createCell(4).setCellValue(subarea.getRegion().getName());
		}
		String filename = "分区数据.xls";
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType(contentType);
		
		//获取客户端浏览器类型
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+filename);
		workBook.write(out);
		workBook.close();
		return NONE;
	}
	
	/**
	 * 查询所有未关联到定区的分区数据，返回json数据
	 * @return
	 */
	public String listajax() {
		List<Subarea> subareaList = subareaService.findUnassociatedSubareaList();
		this.javaToJson(subareaList, new String[] {"decidedzone","region"});
		return NONE;
	}
	private String decidedzoneId;
	/**
	 * 根据decidedzoneId查询分区列表
	 * @return
	 */
	public String findSubareaListByDecidedzoneId() {
		List<Subarea> subareaList=subareaService.findSubareaListByDecidedzoneId(decidedzoneId);
		this.javaToJson(subareaList, new String[] {"decidedzone","subareas"});
		return NONE;
	}

	public String getDecidedzoneId() {
		return decidedzoneId;
	}

	public void setDecidedzoneId(String decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}
}
