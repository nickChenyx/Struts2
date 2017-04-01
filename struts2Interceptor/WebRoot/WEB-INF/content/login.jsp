<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>登录页面</title>
</head>
<body>
<h3>用户登录</h3>
${tip}
<s:form action="loginPro">
	<s:textfield name="username" label="用户名"/>
	<s:password name="password" label="密码"/>
	<s:submit value="登录"/>
</s:form>
</body>
</html>
