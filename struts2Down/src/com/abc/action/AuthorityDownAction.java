package com.abc.action;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.*;

import java.util.Map;
import java.io.InputStream;

/**
 * Description:
 * 下载认证
 * @author  nickChenyx
 * @version  1.0
 */
public class AuthorityDownAction
	implements Action 
{
	private String inputPath;
	public void setInputPath(String value)
	{
		inputPath = value;
	}
	
	public InputStream getTargetFile() throws Exception 
	{
		return ServletActionContext.getServletContext()
			.getResourceAsStream(inputPath);
	}
	
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		String user = (String)session.get("user");
		if ( user !=  null && user.equals("root"))
		{
			return SUCCESS;
		}
		ctx.put("tip"
			, "尚未登录，请使用 root:123456 登录");
		return LOGIN;
	}
}
