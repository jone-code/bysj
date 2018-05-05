<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<input type="hidden" id="adminId" value="${adminId }">
	<form action="<%=request.getContextPath()%>/admin/adminUpdate" method="post" >

		用户：<input type="text" name="name" value="${name }"/><br>
		旧密码：<input type="password" name="old"/><br>
		新密码：<input type="password" name="newOne"/><br>
		确认新密码：<input type="password" name="newTwo"/><br>
		<input type="submit" value="更新"/>
		
	</form>
	<p style="color:red">${errorMessage }</p>
	<p style="color:green">${successMessage }</p>
</body>
</html>
