<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="shopMarketAdd" method="post" enctype="multipart/form-data" onSubmit="return confirm();">

		封面：<input type="file" id="url" name="image" size="12"/><br>
		站点名称：<input type="text" id="name" name="name" value="" /><br>
		地址：<input type="text" id="address" name="address" value="" /><br>
		详细信息：<input type="text" id="info" name="info" value="" /><br>
		<input type="submit" value="添加"/>
		<p style="color:green">${successMessage }</p>
		<p style="color:red">${message }</p>
	</form>
	<p style="color:green">${successMessage }</p>
	<p style="color:red">${message }</p>
  </body>
  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function confirm() {
		var image = $("#url").val();
		if(image==""){
			alert("请选择文件");
			return false;
		}else{
			if (!/\.(jpg|JPG|png|PNG)$/.test(image)) {
				alert("图片类型必须是jpg、png格式");
				$("#iamge").val("");
				return false;
			}
		}
		return true;
	}
</script>
</html>
