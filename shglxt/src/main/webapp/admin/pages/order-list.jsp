<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

-->
</style>
</head>

<body>

<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
		  <td background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> 
			<span class="STYLE4">订单</span></td>
		  <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
		</tr>
	  </table>
	</td>
  </tr>
  <tr>
    <td>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="9" background="images/tab_12.gif">&nbsp;</td>
          <td bgcolor="e5f1d6">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE">
				<tr>
					<td width="5%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">编号</div></td>
					<td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">商品名</div></td>
					<td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">数量</div></td>
					<td width="5%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">价格</div></td>
					<td width="20%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">下单时间</div></td>
					<td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">地址</div></td>
					<td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">顾客</div></td>
					<td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">其他信息</div></td>
					<!-- <td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">出版社</div></td>
					<td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">出版日期</div></td> -->
					<td width="20%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2">操作</div></td>
				</tr>
				
				<!-- 用struts的iterator标签遍历news集合, 并去处每一个name显示 -->
				<c:forEach items="${orderList }" var="order">
	
					<tr>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.number}</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.shopname}</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.shopCount}</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.price}</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.time}</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.address}</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.username}</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${order.info}</div></td>
						<!-- <td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:property value="press"/></div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:property value="pubdate"/></div></td> -->
						<td height="20" bgcolor="#FFFFFF">
							<div align="center">
								<%-- <s:if test="!special"><img src="images/001.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="admin!bookSet.action?id=<s:property value="id"/>&flag=11&status=${status}&page=${page}">设为推荐</a><span class="STYLE1">]</span></s:if>
								<s:if test="special"><img src="images/010.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="admin!bookSet.action?id=<s:property value="id"/>&flag=10&status=${status}&page=${page}">取消推荐</a><span class="STYLE1">]</span></s:if>
								<s:if test="!news"><img src="images/001.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="admin!bookSet.action?id=<s:property value="id"/>&flag=21&status=${status}&page=${page}">设为最新</a><span class="STYLE1">]</span></s:if>
								<s:if test="news"><img src="images/010.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="admin!bookSet.action?id=<s:property value="id"/>&flag=20&status=${status}&page=${page}">取消最新</a><span class="STYLE1">]</span></s:if>
								<s:if test="!sale"><img src="images/001.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="admin!bookSet.action?id=<s:property value="id"/>&flag=31&status=${status}&page=${page}">设为促销</a><span class="STYLE1">]</span></s:if>
								<s:if test="sale"><img src="images/010.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="admin!bookSet.action?id=<s:property value="id"/>&flag=30&status=${status}&page=${page}">取消促销</a><span class="STYLE1">]</span></s:if> --%>
								<img src="images/037.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="toUpdateOrder?id=${order.id}">修改</a><span class="STYLE1">]</span>
								<%-- <img src="images/083.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="deleteShop?id=${shop.id}">删除</a><span class="STYLE1">]</span> --%>
							</div>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
		  </td>
		  <td width="9" background="images/tab_16.gif">&nbsp;</td>
		</tr>
	  </table>
	</td>
  </tr>
  <tr>
    <td height="29">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
			<td background="images/tab_21.gif">${pageTool}</td>
			<td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
		  </tr>
		</table>
	</td>
  </tr>
</table>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	  $(".xstp").on({  
          mouseover : function(){  
        	  $(this).children("div").first().show(); 
          } ,  
          mouseout : function(){  
        	  $(this).children("div").first().hide();
          }   
      }) ; 
	
</script>
</body>
</html>
