package com.itheima.web.bos.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.web.bos.action.base.BaseAction;


/**
 * 角色管理
 * 
 * @author 38295
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	@Autowired
	private IRoleService roleService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleAction() throws InstantiationException, IllegalAccessException {
		super();
	}

	/**
	 * 接收权限id
	 */
	private String functionIds;
	/**
	 * 查询所有的角色数据，返回json
	 * @return
	 */
    public String listajax() {
    	List<Role> roleList = roleService.findAll();
    	this.javaToJson(roleList, new String[] { "functions", "users" });
    	return NONE;
    }
	/**
	 * 添加角色的方法
	 * 
	 * @return
	 */
	public String addRole() {
		roleService.save(model, functionIds);
		return LIST;
	}
  
	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String pageQuery() {
		roleService.pqgeQuery(pageBean);
		this.javaToJson(pageBean, new String[] { "functions", "users" });
		return NONE;
	}

	public String getFunctionIds() {
		return functionIds;
	}

	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}

}
