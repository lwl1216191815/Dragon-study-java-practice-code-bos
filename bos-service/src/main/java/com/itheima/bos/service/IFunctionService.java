package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Function;
import com.itheima.bos.utils.PageBean;

/***
 * 权限service
 * 
 * @author 38295
 *
 */
public interface IFunctionService {
	/**
	 * 查询所有权限数据
	 * 
	 * @return
	 */
	List<Function> findAll();

	/**
	 * 添加权限数据
	 * 
	 * @param model
	 */
	void save(Function model);

	/**
	 * 分页查询方法
	 * 
	 * @param pageBean
	 */
	void pageQuery(PageBean<Function> pageBean);

}
