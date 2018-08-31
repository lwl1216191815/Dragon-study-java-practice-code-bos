package com.itheima.bos.dao;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {
	/**
	 * 根据用户名和密码查找用户
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User findUserByUsernameAndPassword(String username, String password);

	/**
	 * 根据用户名查询用户对象
	 * 
	 * @param username 页面输入的用户名
	 * @return
	 */
	User findUserByUsername(String username);

}
