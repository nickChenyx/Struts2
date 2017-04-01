package com.abc.interceptor;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.*;

/**
 * Description:
 * 用来做身份拦截，没有登录的用户不能查看某些页面
 * @author  nickChenyx
 * @version  1.0
 */

public class AuthorityInterceptor
	extends AbstractInterceptor
{
	@SuppressWarnings("all")
	public String intercept(ActionInvocation invocation)
		throws Exception
	{
		//得到上下文信息
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//从session中获取user
		String user = (String)session.get("user");
		//后端验证
		if (user != null && user.equals("root") )
		{
			//调用下一级的拦截器 ，直至回到Action
			return invocation.invoke();
		}
		//对一切需要登录才能到达的页面做提示
		ctx.put("tip" ,
			"尚未登录，可使用 root:123456登录");
		//ֱ
		return Action.LOGIN;
	}
}
