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

<table width="50%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
		  <td background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> 
			<span class="STYLE4">所有申报</span></td>
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
					<td width="5%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">用户</div></td>
					<td width="10%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">主题</div></td>
					<td width="30%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">详细信息</div></td>
					<td width="30%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2 STYLE1">状态</div></td>
					<td width="20%" height="26" background="images/tab_14.gif" class="STYLE1">
						<div align="center" class="STYLE2">操作</div></td>
				</tr>
				
				<!-- 用struts的iterator标签遍历news集合, 并去处每一个name显示 -->
				<!-- <s:iterator value="adminList"> -->
				<c:forEach items="${declareList }" var="declare">
					<tr>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${declare.id }</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${declare.name }</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${declare.theme }</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">${declare.information }</div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1">
									<c:if test="${declare.statu =='1'}">
										<c:out value="正在处理" />
									</c:if>
									<c:if test="${declare.statu =='2'}">
										<c:out value="正在处理" />
									</c:if>
									<c:if test="${declare.statu =='3'}">
										<c:out value="已完成" />
									</c:if>
							</div></td>
						<td height="20" bgcolor="#FFFFFF">
								<div align="center">
									<%-- <img src="images/037.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="toUpdatePwd?name=${admin.name }">重置密码</a><span class="STYLE1">]</span>
									<img src="images/083.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="adminDelete?id=${admin.id }">删除</a><span class="STYLE1">]</span> --%>
									<c:if test="${declare.statu =='1'}">
										<img src="images/083.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="updateStatu?id=${declare.id }">已处理</a><span class="STYLE1">]</span>
									</c:if>
									<c:if test="${declare.statu =='2'}">
										<img src="images/083.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="updateStatu?id=${declare.id }">已处理</a><span class="STYLE1">]</span>
									</c:if>
								</div>
						</td>
					</tr>
				</c:forEach>	
				<!-- </s:iterator> -->
				
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
			<td background="images/tab_21.gif">
				<!-- <a href="pages/admin-add.jsp">添加管理员</a> -->
			</td>
			<td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
		  </tr>
		</table>
	</td>
  </tr>
</table>

</body>
</html>
