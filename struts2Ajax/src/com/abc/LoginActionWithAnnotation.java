package com.abc;
import java.io.*;

import com.opensymphony.xwork2.Action;


/**
 * Description:
 * Ajax 异步登录 Annotation
 * 配置 注解的方式：https://struts.apache.org/docs/stream-result.html
 * 需要：https://struts.apache.org/docs/convention-plugin.html 

 * @author  nickChenyx
 * @version  1.0
 */

public class LoginActionWithAnnotation implements Action {
		//Action 内定义的字段，可以直接利用setter和getter为字段赋值！
		//网页中传来的参数的名称必须和字段名相同！
		private String user;
		private String pass;
		//利用流将信息回传给网页
		private InputStream inputStream;

		//自动填充
		public void setUser(String user)
		{
			this.user = user;
		}
		public String getUser()
		{
			return this.user;
		}

		//自动填充
		public void setPass(String pass)
		{
			this.pass = pass;
		}
		public String getPass()
		{
			return this.pass;
		}
		
		// getResult() 方法 在struts.xml 中注入了result字段。
		public InputStream getResult(){
			return inputStream;
		}
		
		//实现 Action 接口中的方法，在配置 xml 中没有写明method="methodName" 默认调用的方法 execute
		public String execute() 
			throws Exception 
		{
			//简单的验证数据是否和后台数据相同。
			inputStream = user.equals("root") && pass.equals("123456")
				? new ByteArrayInputStream("success!"
					.getBytes("UTF-8"))
				: new ByteArrayInputStream("failed!"
					.getBytes("UTF-8"));
			// Action中带有的几个 final static 字段
			return SUCCESS;
		}
}
