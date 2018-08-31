package com.itheima.bos.service;

import com.itheima.bos.domain.WorkOrderManage;

/**
 * 快速录取工作单
 * 
 * @author 38295
 *
 */
public interface IWorkOrderManageService {
	/**
	 * 保存工作单
	 * 
	 * @param model
	 */
	void save(WorkOrderManage model);

}
