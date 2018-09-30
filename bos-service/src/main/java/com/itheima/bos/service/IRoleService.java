package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.domain.Role;
import com.itheima.bos.utils.PageBean;

public interface IRoleService {
    /**
     * 增加角色
     * @param model 角色基本信息
     * @param functionIds 角色所拥有的权限id
     */
	void save(Role role, String functionIds);
    /**
     * 分页查询
     * @param pageBean
     */
	void pqgeQuery(PageBean<Role> pageBean);
	/**
	 * 查询所有角色数据
	 * @return
	 */
	List<Role> findAll();

}
