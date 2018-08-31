package com.itheima.web.bos.interceptor;

import com.itheima.bos.domain.User;
import com.itheima.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 自定义拦截器，实现用户未登录，跳转登录页面
 * @author Dragon
 *
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {


	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = BOSUtils.getLoginUser();
		if(user == null) {
			return "login";
		}else {
			return invocation.invoke();
		}
		
	}

}
