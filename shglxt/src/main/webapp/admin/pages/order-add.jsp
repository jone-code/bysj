<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="js/jqueryui/css/jquery-ui-1.10.2.css" />
<script src="js/jqueryui/js/jquery-1.9.1.js"></script>
<script src="js/jqueryui/js/jquery-ui-1.10.2.js"></script>
<script src="js/jqueryui/js/datepicker-zh-CN.js"></script>
<script>
$(function() {
	// 初始化日期插件
	$( "#datepicker" ).datepicker({
		//showButtonPanel: true,//显示按钮栏
		//showOtherMonths: true,//显示其他月份
		//changeMonth: true,//显示月份菜单
		//changeYear: true,//显示年份菜单
		//numberOfMonths: 3,//显示月份数量
		//showOn: "button",//显示按钮
		//buttonImage: "jqueryui/css/images/calendar.gif",//图片地址
		//buttonImageOnly: true,//是否按钮只显示为图片
		//minDate: -3,//开始日期(当天为0)
		//maxDate: "+1Y +1M +1D",//今天之后的天数
	});
	$( "#datepicker" ).datepicker( "option", "zh-CN");
	$( "#datepicker" ).datepicker('setDate', new Date());	//设置初识日期
});
 </script>
</head>
<body>

	<form action="addOrder" method="post" onSubmit="return confirm();">

		
		编号：<input type="text" id="number" name="number" value="" /><br> 
		选择商品：<select id="shop" name="shopid">
				<c:forEach items="${shopList}" var="shop">
					<option value="${shop.id }" >${shop.name }</option>
				</c:forEach>
			</select><br>
		数量：<input type="text" id="shopCount" name="shopCount" value="" /><br>
		价格：<input type="text" id="price" name="price" value="" /><br>
		<!-- 下单时间：<input type="date" id="time" name="time" value=""/><br> -->
		地址：<input type="text" id="address" name="address" value="" /><br>
		顾客：
		 <select id="user" name="userid">
				<c:forEach items="${userList}" var="user">
					<option value="${user.id }" >${user.name }</option>
				</c:forEach>
			</select><br> 
		其他信息：<input type="text" id="info" name="info" value="" /><br>
		<input type="submit" value="添加"/>
		<p style="color:green">${successMessage }</p>
		<p style="color:red">${message }</p>
	</form>
	
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function confirm() {
		var number = $("#number").val();
		var shop = $("#shop").val();
		var shopCount = $("#shopCount").val();
		var price = $("#price").val();
		var address = $("#address").val();
		var user = $("#user").val();
		
		if(number==""||shop==""||shopCount==""||price==""||address==""||user==""){
			alert("请填写信息项");
			return false;
		}
		var reg =/^[0-9]*$/;
		if(!reg.test(number)||!reg.test(shopCount)){
			alert("编号，价格，数量必须为数字");
			return false;
		}
		var reg2=/^\d+(\.\d+)?$/;
		if(!reg2.test(price)){
			alert("价格输入不正确");
			return false;
		}
		return true;
	}
</script>

</html>
