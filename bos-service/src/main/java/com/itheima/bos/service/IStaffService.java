package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.utils.PageBean;

/**
 * 
 * @author Dragon
 *
 */
public interface IStaffService {
	/**
	 * 添加派件员
	 * 
	 * @param model
	 */
	void save(Staff model);

	/**
	 * 分页查询
	 * 
	 * @param pageBean
	 */
	void pageQuery(PageBean<Staff> pageBean);

	/**
	 * 取派员批量删除 逻辑删除，即将deltag改为1
	 * 
	 * @param ids
	 */
	void deleteBatch(String ids);

	/**
	 * 根据id查询取派员
	 * 
	 * @param id
	 * @return
	 */
	Staff findById(String id);

	/**
	 * 根据id修改取派员信息
	 * 
	 * @param staff
	 */
	void update(Staff staff);

	/**
	 * 查询所有未删除的取派员	
	 * 
	 * @return
	 */
	List<Staff> findUnremovedStaffList();

}
