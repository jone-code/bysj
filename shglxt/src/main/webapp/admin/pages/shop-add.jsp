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

	<form action="shopAdd" method="post" enctype="multipart/form-data" onSubmit="return confirm();">

		封面：<input type="file" id="url" name="image" size="12"/><br>
		编号：<input type="text" id="shopNum"
			name="shopNum" value="" /><br> 
		名称：<input type="text" id="name" name="name" value="" /><br>
		价格：<input type="text" id="price" name="price" value="" /><br>
		库存：<input type="text" id="count" name="count" value="" /><br>
		分类: <select id="classid" name="classid">
				<c:forEach items="${shopClassList}" var="shopClass">
					<option value="${shopClass.id }" >${shopClass.name }</option>
				</c:forEach>
			</select><br> 
		<input type="submit" value="添加"/>
		<p style="color:green">${successMessage }</p>
		<p style="color:red">${message }</p>
	</form>
	
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function confirm() {
		var image = $("#url").val();
		var shopNum = $("#shopNum").val();
		var name = $("#name").val();
		var price = $("#price").val();
		var count = $("#count").val();
		var classid = $("#classid").val();
		if(image==""){
			return false;
		}else{
			if (!/\.(jpg|JPG|png|PNG)$/.test(image)) {
				alert("图片类型必须是jpg、png格式");
				$("#iamge").val("");
				return false;
			}
		}
		if(shopNum==""||name==""||price==""||count==""||classid==""){
			alert("请填写信息项");
			return false;
		}
		var reg =/^[0-9]*$/;
		if(!reg.test(shopNum)||!reg.test(price)||!reg.test(count)){
			alert("编号，价格，库存必须为数字");
			return false;
		}
		return true;
	}
</script>

</html>
