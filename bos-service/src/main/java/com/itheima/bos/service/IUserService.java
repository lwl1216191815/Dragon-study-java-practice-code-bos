package com.itheima.bos.service;

import com.itheima.bos.domain.User;

public interface IUserService {
	/**
	 * 用户登录校验
	 * 
	 * @param model
	 * @return
	 */
	User login(User model);

	/**
	 * 根据用户ID修改用户密码
	 * 
	 * @param id
	 * @param password
	 */
	void editPassword(String id, String password);

	/**
	 * 新增用户
	 * 
	 * @param model   用户实体数据
	 * @param roleIds 用户对应角色
	 */
	void save(User user, String[] roleIds);

}
