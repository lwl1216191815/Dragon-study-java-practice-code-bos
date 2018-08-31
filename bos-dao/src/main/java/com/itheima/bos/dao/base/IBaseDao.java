package com.itheima.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.bos.utils.PageBean;

/**
 * 持久层通用接口
 * 
 * @author Dragon
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	/**
	 * 保存或者修改
	 */
	void saveOrUpdate(T entity);

	/**
	 * 增加一个实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除一个实体
	 * 
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * 修改一个实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 根据id查询一个实体
	 * 
	 * @param id
	 * @return
	 */
	T findById(Serializable id);

	/**
	 * 查询所有实体
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 通用的修改方法，执行更新
	 * 
	 * @param queryName
	 * @param objects
	 */
	void executeUpdate(String queryName, Object... objects);

	/**
	 * 通用的分页查询
	 * 
	 * @param pageBean
	 */
	void pageQuery(PageBean<T> pageBean);

	/**
	 * 通用的条件查询方法
	 * 
	 * @param detachedCriteria
	 * @return
	 */
	List<T> findByCriteria(DetachedCriteria detachedCriteria);
}
