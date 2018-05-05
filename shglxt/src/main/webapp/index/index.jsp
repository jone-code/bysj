<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>售后商城首页</title>
</head>
<body>

	<div id="wrap">

		<jsp:include page="../index/header.jsp" />

		<div class="center_content">

			<div class="left_content">
				<c:forEach items="${shopList}" var="shop">

					<div class="feat_prod_box">
						<div class="prod_img">
							<a href="detail.action?bookid=${shop.id}"><img
								src="${shop.image}" class="thumb_big" /></a>
						</div>
						<div class="prod_det_box">
							<div class="box_top"></div>
							<div class="box_center">
								<span class="special_icon"><img
									src="/images/special_icon.gif"></span>

								<div class="prod_title">
									<a href="detail.action?bookid=${shop.id}">${shop.name}</a>
								</div>
								<div class="prod_title">
									<p>价格：${shop.price }</p>
								</div>
								<div class="prod_title">
									<p>库存：${shop.count }</p>
								</div>
								<!-- <p class="details">
									<s:property
										value="intro.substring(0,(intro.length()>70?70:intro.length()))+'...'" />
								</p> -->
								<%-- <a href="detail.action?bookid=${shop.id}" class="more">- 详情
									-</a> --%>
								<div class="clear"></div>
							</div>
							<div class="box_bottom"></div>
						</div>
						<div class="clear"></div>
					</div>
				</c:forEach>

				<div class="clear"></div>
				<c:forEach items="${shopMarkets}" var="market">
					<div class="feat_prod_box">
						<div class="prod_img">
							<a href="detail.action?bookid=${market.id}"><img
								src="${market.image}" class="thumb_big" /></a>
						</div>
						<div class="prod_det_box">
							<div class="box_top"></div>
							<div class="box_center">
								<span class="special_icon"><img
									src="/images/special_icon.gif"></span>

								<div class="prod_title">
									<a href="detail.action?bookid=${market.id}">${market.name}</a>
								</div>
								<div class="prod_title">
									<p>地址：${market.address }</p>
								</div>
								<div class="prod_title">
									<p>信息：${market.info }</p>
								</div>

								<div class="clear"></div>
							</div>
							<div class="box_bottom"></div>
						</div>
						<div class="clear"></div>
					</div>

				</c:forEach>
			</div>

			<div class="feat_prod_box_details updatePwd">

				<div class="contact_form ">
					<div class="form_subtitle">修改密码</div>
					<div class="form_row">
						<label class="contact"><strong>用户:</strong></label>
						<!-- <input type="text" name="name" class="contact_input" /> -->
						<span>${name }</span>
					</div>
					<div class="form_row">
						<label class="contact"><strong>旧密码:</strong></label> <input
							type="password" id="old" name="password" class="contact_input" />
					</div>
					<div class="form_row">
						<label class="contact"><strong>新密码:</strong></label> <input
							type="password" id="newOne" name="password" class="contact_input" />
					</div>
					<div class="form_row">
						<label class="contact"><strong>确认密码:</strong></label> <input
							type="password" id="newTwo" name="password" class="contact_input" />
					</div>
					<div class="form_row"></div>
					<div class="form_row">
						<input type="button" class="register" id="submit" value="确定"
							style="margin-right:10px" />
					</div>
				</div>

			</div>

			<div class="clear"></div>




			<div class="announcement">
				<c:forEach items="${announcementList }" var="announcement">
					<div class="feat_prod_box_details">
						<div class="prod_det_box">
							<div class="box_top"></div>
							<div class="box_center">
								<div class="prod_title">
									<span style="color:black">标题:</span>
									<span>${announcement.theme }</span>
								</div>
								<div class="prod_title">
									<span style="color:black">内容:</span>
									<span>${announcement.information }</span>
								</div>
							</div>
							<div class="clear"></div>
							<div class="box_bottom"></div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="clear"></div>
			<div class="declare">
				<c:forEach items="${declareList}" var="declare">
					<div class="feat_prod_box_details">
						<div class="prod_det_box">
							<div class="prod_title">
								<span style="color:black">标题:</span>
								<span>${declare.theme}</span>
							</div>
							<div class="prod_title">
								<span style="color:black">内容:</span>
								<span>${declare.information }</span>
							</div>
							<div class="prod_title">
								<span style="color:black">状态:</span>
								<span>
									<c:if test="${declare.statu =='1'}">
										<c:out value="正在处理" />
									</c:if>
									<c:if test="${declare.statu =='2'}">
										<c:out value="正在处理" />
									</c:if>
									<c:if test="${declare.statu =='3'}">
										<c:out value="已完成" />
									</c:if>
								</span>
							</div>
							<div class="prod_title">
								<span><a href="deleteDeclare?id=${declare.id }">删除个人申报</a>
								</span>
							</div>
							<div class="clear"></div>
							<div class="box_bottom"></div>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="clear"></div>
			
			<div class="feat_prod_box_details addDeclare">

				<div class="contact_form ">
					<div class="form_subtitle">添加申报</div>
					<div class="form_row">
						<label class="contact"><strong>标题</strong></label> <input
							type="text" id="d_theme" name="d_theme" class="contact_input" />
					</div>
					<div class="form_row">
						<label class="contact"><strong>详细信息:</strong></label> <input
							type="text" id="d_info" name="d_info" class="contact_input" />
					</div>
					<div class="form_row"></div>
					<div class="form_row">
						<input type="button" class="register" id="submitDeclare" value="确定"
							style="margin-right:10px" />
					</div>
				</div>

			</div>
			<div class="clear"></div>
		</div>

		<jsp:include page="../index/footer.jsp" />

	</div>
	<input type="hidden" id="isupdatepwd" value="${isupdatepwd }">
	<input type="hidden" id="isAddDeclare" value="${isAddDeclare }">
</body>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function() {
		if ($("#isupdatepwd").val()) {
			$(".updatePwd").show();
		} else {
			$(".updatePwd").hide();
		}
		
		if ($("#isAddDeclare").val()) {
			$(".addDeclare").show();
		} else {
			$(".addDeclare").hide();
		}
	});

	$("#submit").click(function() {
		var old = $("#old").val();
		var newOne = $("#newOne").val();
		var newTwo = $("#newTwo").val();
		$.ajax({
			url : "updatePassword",
			type : "GET",
			data : {
				'old' : old,
				'newOne' : newOne,
				'newTwo' : newTwo
			},
			success : function(res) {
				if (res == "1") {
					alert("新密码输入不正确，请检查");
				} else if (res == "2") {
					alert("旧密码不正确");
				} else {
					alert("修改成功");
				}
			}
		});
	});
	
	
	$("#submitDeclare").click(function() {
		var theme = $("#d_theme").val();
		var info = $("#d_info").val();
		if(theme==""||info==""){
			alert("请填写信息项");
		}else{
			$.ajax({
				url : "updateDeclare",
				type : "GET",
				data : {
					'd_theme' : theme,
					'd_info' : info
				},
				success : function(res) {
					if (res == "ok") {
						alert("添加成功");
					} else {
						alert("添加失败");
					}
				}
			});
		}
	});
</script>
</html>