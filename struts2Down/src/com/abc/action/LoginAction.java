package com.abc.action;

import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Description:
 * 登录
 * @author  nickChenyx
 * @version  1.0
 */
public class LoginAction implements Action 
{
	private String user;
	private String pass;
	
	//自动注入 
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getUser()
	{
		return this.user;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}
	
	public String execute()
	{
		ActionContext.getContext().getSession()
			.put("user" , getUser());
		return SUCCESS;
	}
}