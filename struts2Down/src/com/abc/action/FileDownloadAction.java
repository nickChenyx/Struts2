package com.abc.action;

import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.*;

/**
 * Description:
 * 文件下载
 * @author  nickChenyx
 * @version  1.0
 */
public class FileDownloadAction
	extends ActionSupport 
{
	//被下载的资源的地址
	private String inputPath;
	//从xml中注入
	public void setInputPath(String value)
	{
		inputPath = value;
	}
	/*
		返回流的形式注入到xml中的targetFile中
	*/
	public InputStream getTargetFile() throws Exception 
	{
		return ServletActionContext.getServletContext()
			.getResourceAsStream(inputPath);
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
