<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="categoryUpdate" method="post" >
	
		<%-- <input type="hidden" name="page" value="${param.page}"/> --%>

		<input type="hidden" name="id" value="${category.id}"/>
		
		名称：<input type="text" name="name" value="${category.name}"/>
		
		<input type="submit" value="修改"/>
		
	</form>
	<p style="color:red">${message }</p>
</body>
</html>
