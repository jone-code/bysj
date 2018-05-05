<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index/css/style.css"/>
<script type="text/javascript" src="index/js/jquery.js"></script>
</head>

<body>
<input type="hidden" id="userid" value="${name }">
<div class="header">
   <!--  <div class="logo">
	    	<img src="/index/images/logo2.jpg"  />
    </div> -->
    
    <div id="menu">
		<ul>
			<li><a href="firstPage" class="sy">首页</a></li>
			<li><a href="getAllAnnouncement" >公告</a></li>
			<li><a href="selectAllShopMarket" >售后站点</a></li>
			<li><a href="admin/login.jsp" target="_blank">后台管理</a></li>
				<li class="y"><a href="loginPage" >用户登陆</a></li>
				<li class="y"><a href="register.action" >用户注册</a></li>
				
				<li class="n"><a href="updatepwd" >修改密码</a></li>
				<li class="n"><a href="logout" class="logout">注销登录</a></li>
				<li class="n"><a href="getDeclareByUser" >个人申报</a></li>
				<li class="n"><a href="toAddDeclareByUser" >添加申报</a></li>
 				<%-- <li class="y"><a href="order.action">我的订单(${name })</a></li> --%>
				
			<li style="float: right; margin-right: 10px;">
				<%-- <form action="search.action" method="post" id="form_search">
					<a href="javascript:void(0);" onclick="$('#form_search').submit()" style="float: right;margin-left:0">搜索</a>
					<input type="text" name="searchName" value="${searchName}" placeholder="" />
				</form> --%>
			</li>
		</ul>
    </div>
</div>

</body>

<script type="text/javascript">
$(function(){
	
	if($("#userid").val()==""){
		
		$(".y").show();
		$(".n").hide();
	}else{
		$(".y").hide();
		$(".n").show();
	}
	
	/* $(".logout").click(function(){
		$.ajax({
			url:"logout",
			type:"GET"
		});
	}); */
	
});
</script>
</html>