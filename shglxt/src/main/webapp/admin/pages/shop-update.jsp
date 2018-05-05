<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="js/jqueryui/css/jquery-ui-1.10.2.css" />
<script src="js/jqueryui/js/jquery-1.9.1.js"></script>
<script src="js/jqueryui/js/jquery-ui-1.10.2.js"></script>
<script src="js/jqueryui/js/datepicker-zh-CN.js"></script>
</head>
<body>

	<form action="shopUpdate" method="post" enctype="multipart/form-data"
		onSubmit="return confirm();">

		<%-- <input type="hidden" name="page" value="${param.page}"/> --%>

		<input type="hidden" name="id" value="${shop.id}" /> 
		<input type="hidden" name="cover" value="${shop.image}" /> 
		封面：<img src="<%=request.getContextPath()%>/${shop.image}" width="150px"
			height="150px"> <br> 
		修改: <input type="file" id="url" name="image" size="12" value=""/><br> 
		编号：<input type="text" id="shopNum"
			name="shopNum" value="${shop.shopNum}" /><br> 
		名称：<input type="text" id="name" name="name" value="${shop.name}" /><br>
		价格：<input type="text" id="price" name="price" value="${shop.price}" /><br>
		库存：<input type="text" id="count" name="count" value="${shop.count}" /><br>
		分类: <select id="classid" name="classid">
				<c:forEach items="${shopClassList}" var="shopClass">
					<option value="${shopClass.id }" 
						<c:if test = "${shopClass.id == shop.shopclassId}">
							selected="selected"
						</c:if>
					>${shopClass.name }</option>
				</c:forEach>
			</select><br> 
		<input type="submit" value="修改" />
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
		
		/* if (!/\.(jpg|JPG|png|PNG)$/.test(image)) {
			alert("图片类型必须是jpg、png格式");
			$("#iamge").val("");
			return false;
		} */
		if(shopNum==""||name==""||price==""||count==""||classid==""){
			alert("请填写信息项");
			return false;
		}
		var reg =/^[0-9]*$/;
		if(!reg.test(shopNum)||!reg.test(count)){
			alert("编号,库存必须为数字");
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
