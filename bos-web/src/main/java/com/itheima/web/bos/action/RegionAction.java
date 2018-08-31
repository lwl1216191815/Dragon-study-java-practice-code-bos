package com.itheima.web.bos.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Region;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.utils.PinYin4jUtils;
import com.itheima.web.bos.action.base.BaseAction;

/**
 * 区域管理
 * 
 * @author Dragon
 *
 */
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {

	@Autowired
	private IRegionService regionService;
	
	private String q;

	public RegionAction() throws InstantiationException, IllegalAccessException {
		super();
	}

	public File getRegionFile() {
		return regionFile;
	}

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File regionFile;

	/**
	 * 区域导入文件 使用POI解析Excel 根据名称获得指定Sheet对象
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public String importXls() throws FileNotFoundException, IOException {
		List<Region> regionList = new ArrayList<Region>();
		HSSFWorkbook workBook = new HSSFWorkbook(new FileInputStream(regionFile));
		HSSFSheet sheet = workBook.getSheet("Sheet1");
		for (Row row : sheet) {
			int num = row.getRowNum();
			if (num == 0) {
				continue;
			}
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			Region region = new Region(id, province, city, district, postcode, null, null, null);

			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortCode = StringUtils.join(headByString);
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			region.setShortcode(shortCode);
			region.setCitycode(citycode);

			regionList.add(region);
		}
		regionService.saveBatch(regionList);
		workBook.close();
		return NONE;
	}

	/**
	 * 分页查询
	 * @return
	 * @throws IOException 
	 */
    public String pageQuery() throws IOException {
		regionService.pageQuery(pageBean);
		this.javaToJson(pageBean, new String[] { "currentPage", "detachedCriteria", "pageSize","subareas" });
    	return NONE;
    }
    /**
     * 查詢所有區域，写回json數據
     * @return
     */
    public String listajax() {
    	List<Region> regionList = null;
    	if(StringUtils.isNotBlank(q)) {
    		regionList = regionService.findByQ(q);
    	}else {
    		regionList = regionService.findAll();
    	}
    	this.javaToJson(regionList, new String[] {"subareas"});
    	return NONE;
    }

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
}
