package com.itheima.bos.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.domain.User;

/**
 * 
 * @author 38295
 *
 */
public class BOSRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserDao userDao;
	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		/**
		 * 为用户授权
		 */
		//TODO 后期需要更改为当前登录用户查数据库
		info.addStringPermission("staff-list");
		return info;
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//根据用户名查询数据库中的密码
		UsernamePasswordToken uptoken=(UsernamePasswordToken)token;
		//获得页面输入的用户名
		String username = uptoken.getUsername();
		User user=userDao.findUserByUsername(username);
		if(user == null) {
			//说明页面输入的用户不存在
			return null;
		}else {
			//框架负责比对用户输入的密码和数据库中的密码是否一致
			//简单认证对象信息
			AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
			return info;
		}
		
	}

}
