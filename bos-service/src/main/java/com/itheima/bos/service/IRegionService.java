package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Region;
import com.itheima.bos.utils.PageBean;

public interface IRegionService {
	/**
	 * 保存excel表中的区域数据 区域数据批量保存
	 * 
	 * @param regionList
	 */
	void saveBatch(List<Region> regionList);

	/**
	 * 分页查询区域数据
	 * 
	 * @param pageBean
	 */
	void pageQuery(PageBean<Region> pageBean);

	/**
	 * 查询所有区域数据
	 * 
	 * @return
	 */
	List<Region> findAll();

	/**
	 * 根据页面输入进行模糊查询
	 * 
	 * @param q
	 *            页面输入字段
	 * @return
	 */
	List<Region> findByQ(String q);

}
