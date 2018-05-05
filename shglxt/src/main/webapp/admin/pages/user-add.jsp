<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="userAdd" method="post" >

		用户：<input type="text" name="name"/><br>
		密码：<input type="password" name="password"/><br>
		电话：<input type="text" name="phone"/>
		<input type="submit" value="添加"/>
		
	</form>
	<p style="color:green">${successMessage }</p>
	<p style="color:red">${message }</p>
</body>
</html>
