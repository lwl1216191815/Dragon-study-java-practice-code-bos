package com.itheima.web.bos.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;
import com.itheima.web.bos.action.base.BaseAction;

/**
 * 业务通知单管理
 * 
 * @author 38295
 *
 */
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private INoticebillService noticebillService;

	public NoticebillAction() throws InstantiationException, IllegalAccessException {
	}

	/**
	 * 远程调用CRM服务，根据手机号获取客户信息，返回JSON串
	 * 
	 * @return
	 */
	public String findCustomerByTelephone() {
		Customer customer = customerService.findCustomerByTelephone(model.getTelephone());
		this.javaToJson(customer, null);
		return NONE;
	}
	/**
	 * 
	 * @return
	 */
	public String addNoticebill() {
		noticebillService.saveNoticebill(model);
		return "notice_add";
	}
	
}
