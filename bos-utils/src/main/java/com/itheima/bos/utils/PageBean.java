package com.itheima.bos.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 分页工具类
 * 
 * @author Dragon
 * @param <T>
 *
 */
public class PageBean<T> {
	/**
	 * 当前页码
	 */
	private int currentPage;
	/**
	 * 每页显示的记录数
	 */
	private int pageSize;
	/**
	 * 查询条件
	 */
	private DetachedCriteria detachedCriteria;

	/**
	 * 总记录数
	 */
	private int total;
	/**
	 * 当前页需要展示的数据集合
	 */
	private List<T> rows;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
