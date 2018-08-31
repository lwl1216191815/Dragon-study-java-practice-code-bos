package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Subarea;
import com.itheima.bos.utils.PageBean;

public interface ISubareaService {
	/**
	 * 添加分区
	 * 
	 * @param model
	 */
	void save(Subarea model);

	/**
	 * 分页查询分区
	 * 
	 * @param pageBean
	 */
	void pageQuery(PageBean<Subarea> pageBean);

	/**
	 * 查询所有的分区数据
	 * 
	 * @return
	 */
	List<Subarea> findaAll();

	/**
	 * 查询所有未关联到定区的分区数据
	 * 
	 * @return
	 */
	List<Subarea> findUnassociatedSubareaList();

	/**
	 * 根据定区id查询分区列表
	 * @return
	 */
	List<Subarea> findSubareaListByDecidedzoneId(String decidedzoneId);

}
