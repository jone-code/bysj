<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index/css/style.css"/>
<script type="text/javascript" src="index/js/jquery.js"></script>
</head>
<body>
<div class="header">

    <div class="logo">
	    <a href="index.action">
	    	<img src="index/images/logo.gif" border="0" /></a>
    </div>
    
    <div id="menu">
		<ul>
			<li ><a href="">首页(公告)</a></li>
			<li ><a href="">精品推荐</a></li>
			<li ><a href="">个人信息管理</a></li>
			<li ><a href="">我的订单</a></li>
			<li ><a href="">售后站点查询</a></li>
			<!-- <s:if test="#session.username==null"> -->
				<li ><a href="loginPage">用户登陆</a></li>
				<li ><a href="register.action">用户注册</a></li>
				<li><a href="../admin/login.jsp" target="_blank">后台管理</a></li>
			<!-- </s:if>
			<s:else>
 -->				<li><a href="order.action">我的订单(<s:property value="#session.username"/>)</a></li>
				<li><a href="user!logout.action">注销登录</a></li>
			<!-- </s:else> -->
			<li style="float: right; margin-right: 10px;">
				<form action="search.action" method="post" id="form_search">
					<a href="javascript:void(0);" onclick="$('#form_search').submit()" style="float: right;margin-left:0">搜索</a>
					<input type="text" name="searchName" value="${searchName}" placeholder="" />
				</form>
			</li>
		</ul>
    </div>
</div>

</body>
</html>