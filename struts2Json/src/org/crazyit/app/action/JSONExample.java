package org.crazyit.app.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.json.annotations.JSON;
/**
 * Description:
 * @author  
 * @version  1.0
 */
public class JSONExample
{
	//
	private int[] ints = {10, 20};
	private Map<String , String> map
		= new HashMap<String , String>();
	private String customName = "用户输入的数据";
	private String field1;
	private transient String field2;
	private String field3;
	
	public String execute()
	{
		map.put("name", "后台传入的数据");
		return Action.SUCCESS;
	}

	//
	@JSON(name="backToFront")
	public Map getMap()
	{
		return this.map;
	}
	
	//
	public void setCustomName(String customName)
	{
		this.customName = customName;
	}
	public String getCustomName()
	{
		return this.customName;
	}

	public void setField1(String field1)
	{
		this.field1 = "处理："+field1;
	}
	public String getField1()
	{
		return this.field1;
	}

	public void setField2(String field2)
	{
		this.field2 = "处理："+field2;
	}
	public String getField2()
	{
		return this.field2;
	}

	public void setField3(String field3)
	{
		this.field3 = "处理："+field3;
	}
	public String getField3()
	{
		return this.field3;
	}
}