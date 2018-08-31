package com.itheima.web.bos.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.WorkOrderManage;
import com.itheima.bos.service.IWorkOrderManageService;
import com.itheima.web.bos.action.base.BaseAction;

/**
 * 快速录入工作单
 * 
 * @author 38295
 *
 */
@Controller
@Scope("prototype")
public class WorkOrderManageAction extends BaseAction<WorkOrderManage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IWorkOrderManageService workOrderManageService;

	/**
	 * 工作单快速录入
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		String f = "1";
		try {
			workOrderManageService.save(model);
		} catch (Exception e) {
			e.printStackTrace();
			f = "0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}

	public WorkOrderManageAction() throws InstantiationException, IllegalAccessException {
		super();
		// TODO Auto-generated constructor stub
	}

}
