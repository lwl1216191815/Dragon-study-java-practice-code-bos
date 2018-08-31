package com.itheima.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.bos.domain.User;

/**
 * BOS工具类
 * 
 * @author Dragon
 *
 */
public class BOSUtils {
	/**
	 * 获取session对象
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * 获取已经登录的用户对象
	 * 
	 * @return
	 */
	public static User getLoginUser() {
		return (User) getSession().getAttribute("loginUser");
	}
}
