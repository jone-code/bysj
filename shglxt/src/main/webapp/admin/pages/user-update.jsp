<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="userUpdatePhone" method="post" >
	
		<%-- <input type="hidden" name="page" value="${param.page}"/>

		<input type="hidden" name="user.id" value="${user.id}"/>
		<input type="hidden" name="user.username" value="${user.username}"/>
		<input type="hidden" name="user.password" value="${user.password}"/> --%>
		<input type="hidden" name="id" value="${user.id}"/>
		用户：${user.name}<br>
		电话：<input type="text" name="phone" value="${user.phone}"/>
		<input type="submit" value="修改"/>
		
	</form>
	
</body>
</html>
