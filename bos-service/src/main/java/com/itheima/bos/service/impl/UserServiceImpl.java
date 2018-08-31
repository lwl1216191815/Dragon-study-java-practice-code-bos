package com.itheima.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.UserService;
import com.itheima.bos.utils.MD5Utils;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User login(User model) {
		String password = MD5Utils.md5(model.getPassword());
		
		return userDao.findUserByUsernameAndPassword(model.getUsername(),password);
	}

	@Override
	public void editPassword(String id, String password) {
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editPassword", password,id);
	}

}
