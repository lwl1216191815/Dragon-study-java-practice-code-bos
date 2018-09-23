package com.itheima.web.bos.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Function;
import com.itheima.bos.service.IFunctionService;
import com.itheima.web.bos.action.base.BaseAction;

/**
 * 权限管理控制层
 * 
 * @author 38295
 *
 */
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IFunctionService functionService;

	public FunctionAction() throws InstantiationException, IllegalAccessException {
		super();
	}

	/**
	 * 查询权限数据，写回前台
	 * 
	 * @return
	 */
	public String listajax() {
		List<Function> functionList = functionService.findAll();
		this.javaToJson(functionList, new String[] { "parentFunction", "roles" });
		return NONE;
	}
	/**
	 * 添加权限的方法
	 * @return
	 */
	public String addFunction() {
		functionService.save(model);
		return LIST;
	}
	/**
	 * 分页查询方法
	 * @return
	 */
	public String pageQuery() {
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		functionService.pageQuery(pageBean);
		this.javaToJson(pageBean, new String[] { "parentFunction", "roles", "children" });
		return NONE;
	}
}
