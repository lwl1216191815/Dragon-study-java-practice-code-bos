package com.itheima.web.bos.action;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.User;
import com.itheima.bos.service.UserService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.bos.utils.MD5Utils;
import com.itheima.web.bos.action.base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	private static final long serialVersionUID = 1L;
	/**
	 * 验证码
	 */
	private String checkcode;
	/**
	 * 注入Service
	 */
	@Autowired
	private UserService userService;

	public UserAction() throws InstantiationException, IllegalAccessException {
		super();
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	/**
	 * 
	 */

	/**
	 * 用户登录,使用shiro框架提供的方式进行认证
	 * 
	 * @return
	 */
	public String login() {
		String validatecode = (String) BOSUtils.getSession().getAttribute("key");

		if (StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)) {
			Subject subject = SecurityUtils.getSubject();//获取当前用户对象，状态为未认证
			String username = model.getUsername();
			String password = MD5Utils.md5(model.getPassword());
			AuthenticationToken token = new UsernamePasswordToken(username, password);
			try {
				subject.login(token);
			}catch (Exception e) {
				e.printStackTrace();
				return LOGIN;
			}
			User user = (User) subject.getPrincipal();
			BOSUtils.getSession().setAttribute("loginUser", user);
			return HOME;
		} else {
			this.addActionError("输入的验证码有误");
			return LOGIN;
		}
	}
	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String login_bak() {
		String validatecode = (String) BOSUtils.getSession().getAttribute("key");
		if (StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)) {
			User user = userService.login(model);
			if (user != null) {
				BOSUtils.getSession().setAttribute("loginUser", user);
				return HOME;
			} else {
				this.addActionError("账户密码不匹配");
				return LOGIN;
			}
		} else {
			this.addActionError("输入的验证码有误");
			return LOGIN;
		}
	}
	/**
	 * 用户注销
	 * 
	 * @return
	 */
	public String logout() {
		BOSUtils.getSession().invalidate();
		return LOGIN;
	}

	/**
	 * 登录用户修改密码
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String editPassword() throws IOException {
		String f= "1";
		User user = BOSUtils.getLoginUser();
		try {
			userService.editPassword(user.getId(),model.getPassword());	
		} catch(Exception e) {
			f = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(f);
		return NONE;
	}
}
