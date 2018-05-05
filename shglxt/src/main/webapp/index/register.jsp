<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

<div id="wrap">

<jsp:include page="header.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<div class="title"><span class="title_icon"><img src="images/bullet1.gif"/></span>用户注册</div>
		
		<div class="feat_prod_box_details">
		
			<div class="contact_form">
				<div class="form_subtitle">用户注册</div>
				<form action="register" method="post">
					<div class="form_row">
						<label class="contact"><strong>用户:</strong></label>
						<input type="text" name="name" class="contact_input" />
					</div>
					<div class="form_row">
						<label class="contact"><strong>密码:</strong></label>
						<input type="password" name="password" class="contact_input" />
					</div>
					<div class="form_row">
						<label class="contact"><strong>电话:</strong></label>
						<input type="text" name="phone" class="contact_input" />
					</div>
					<div class="form_row">
						<input type="submit" class="register" value="注册" style="margin-right:10px"/>
						<!-- <a href="login.action" style="float:right;margin:8px">已有账户? 点击登录</a> -->
					</div>
					<p style="color:red">${message}</p>
				</form>
			</div>
  
		</div>

		<div class="clear"></div>
	
	</div>
   
   
	<div class="clear"></div>
	
</div>

<jsp:include page="footer.jsp"/>

</div>

</body>
</html>