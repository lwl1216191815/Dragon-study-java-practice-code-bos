package com.itheima.web.bos.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.web.bos.action.base.BaseAction;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 服务层实例
	 */
	@Autowired
	private IStaffService staffService;
	private String ids;


	/**
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public StaffAction() throws InstantiationException, IllegalAccessException {
		super();
	}

	/**
	 * 添加派件员
	 * 
	 * @return
	 */
	public String add() {
		staffService.save(model);
		return LIST;
	}

	/**
	 * 分页查询方法
	 * 
	 * @return
	 * @throws IOException
	 */
	public String pageQuery() throws IOException {
		staffService.pageQuery(pageBean);
        this.javaToJson(pageBean, new String[] { "currentPage", "detachedCriteria", "pageSize","decidedzones" });
		return NONE;
	}

	/**
	 * 取派员批量删除
	 * 
	 * @return
	 */
	@RequiresPermissions("staff-delete")
	public String deleteBatch() {
		staffService.deleteBatch(ids);
		return LIST;
	}
	
    /**
     * 修改取派员信息
     * @return
     */
	public String edit() {
		Staff staff = staffService.findById(model.getId());
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return LIST;
	}
	/**
	 * 查询所有未删除的取派员，并且返回json数据
	 * @return
	 */
	public String listajax() {
		List<Staff> staffList = staffService.findUnremovedStaffList();
		this.javaToJson(staffList, new String[] {"telephone","haspda","deltag","station","standard","decidedzones"});
		return NONE;
	}
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
