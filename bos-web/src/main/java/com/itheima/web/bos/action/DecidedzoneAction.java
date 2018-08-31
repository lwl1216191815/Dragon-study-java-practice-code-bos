package com.itheima.web.bos.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.service.IDeciedService;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;
import com.itheima.web.bos.action.base.BaseAction;


@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {

	/**
	 * 默认的序列化编号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用来接收多个分区id
	 */
	private String[] subareaid;
	private List<Integer> customerIds;
	/**
	 * 定区管理的服务对象
	 */
	@Autowired
	private IDeciedService decidedService;
	/**
	 * 注入代理对象
	 */
	@Autowired
	private ICustomerService customerService;

	public DecidedzoneAction() throws InstantiationException, IllegalAccessException {
		super();
	}

	public String[] getSubareaid() {
		return subareaid;
	}

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}

	/**
	 * 添加定区
	 * 
	 * @return
	 */
	public String addDecidedzone() {
		decidedService.save(model, subareaid);
		return LIST;
	}

	/**
	 * 分页查询方法
	 * 
	 * @return
	 */
	public String pageQuery() {
		decidedService.pageQuery(pageBean);
		this.javaToJson(pageBean,
				new String[] { "currentPage", "detachedCriteria", "pageSize", "subareas", "decidedzones" });
		return NONE;
	}

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 定区与客户相互关联
	 * 
	 * @return
	 */
	public String findCustomerListNotAssociation() {
		List<Customer> list = customerService.findCustomerListNotAssociation();
		this.javaToJson(list, null);
		return NONE;
	}

	/**
	 * 远程调用CRM服务，查询已经关联定区的客户
	 * 
	 * @return
	 */
	public String findCustomerListHasAssociation() {
		String id = model.getId();
		List<Customer> list = customerService.findCustomerListHasAssociation(id);
		this.javaToJson(list, null);
		return NONE;
	}
	/**
	 * 远程调用CRM，将客户关联到定区
	 * @return
	 */
	public String assignCustomersToDecidedzone() {
		customerService.assignCustomersToDecidedzone(model.getId(),customerIds);;
		return LIST;
	}

	public List<Integer> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
}
