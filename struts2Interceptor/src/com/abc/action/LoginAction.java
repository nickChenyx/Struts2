package com.abc.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;
/**
 * Description:
 * 登录请求会在这里被拦截
 * @author  nickChenyx
 * @version  1.0
 */
public class LoginAction extends ActionSupport
{
	private String username;
	private String password;
	
	//自动注入
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	//自动注入
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	
	public String execute() throws Exception
	{
		System.out.println("执行 LoginAction ..........");
		if (getUsername().equals("root")
			&& getPassword().equals("123456") )
		{
			
			ActionContext ctx = ActionContext.getContext();
			//从上下文中拿到 session
			Map session = ctx.getSession();
			session.put("user" , getUsername());
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
	
	public String logout() throws Exception{
		//退出登录状态
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().clear();
		return SUCCESS;
	}
}