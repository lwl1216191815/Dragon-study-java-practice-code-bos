package com.itheima.bos.service;

import com.itheima.bos.domain.User;

public interface UserService {
   /**
    * 用户登录校验
    * @param model
    * @return
    */
   public User login(User model);
/**
 * 根据用户ID修改用户密码
 * @param id
 * @param password
 */
   public void editPassword(String id, String password);

}
