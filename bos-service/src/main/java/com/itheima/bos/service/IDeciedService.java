package com.itheima.bos.service;

import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.utils.PageBean;

public interface IDeciedService {
	/**
	 * 添加定区,同时关联分区
	 * 
	 * @param model
	 * @param subareaid
	 */
	void save(Decidedzone model, String[] subareaid);

	/**
	 * 分页查询方法
	 * 
	 * @param pageBean
	 */
	void pageQuery(PageBean<Decidedzone> pageBean);

}
