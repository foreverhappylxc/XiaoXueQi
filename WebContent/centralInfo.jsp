<%@page import="entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/centralInfo.css">
<script type="text/javascript" src="js/centralInfo.js"></script>
</head>
<body>
	<%@ include file="top.jsp" %>
	<div align="center">
		<% if (request.getAttribute("customer") != null) {%>
			<% Customer customer = (Customer)request.getAttribute("customer"); %>
			<table>
				<tr>
					<td>
						用户号: &nbsp;
					</td>
					<td>
						<input disabled="disabled" class="cu_id" value="<%= customer.getCu_id() %>" maxlength="15">
					</td>
					<td rowspan="3" colspan="2">
						<img class="cu_img" alt="img" src="<%= "userImage/" + session.getAttribute("cu_id") + ".png" %>" width="300px" height="300px">
					</td>
				</tr>
				<tr>
					<td>
						用户密码: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="password" class="cu_pwd" value="<%= customer.getCu_pwd() %>" maxlength="15">
					</td>
				</tr>
				<tr>
					<td>
						用户名: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_name" value="<%= customer.getCu_name() %>" maxlength="15">
					</td>
				</tr>
				<tr>
					<td>
						昵称: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_nickname" value="<%= customer.getCu_nickname() %>" maxlength="15">
					</td>
					<td>
						年龄: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_age" value="<%= customer.getCu_age() %>" maxlength="3"
						onkeyup="this.value=this.value.replace(/\D/g,'')">
					</td>
				</tr>
				<tr>
					<td>
						性别: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_sex" value="<%= customer.getCu_sex() %>" maxlength="1">
					</td>
					<td>
						邮箱: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_email" value="<%= customer.getCu_email() %>" maxlength="30">
					</td>
				</tr>
				<tr>
					<td>
						信誉值: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_credit" value="<%= customer.getCu_credit() %>">
					</td>
					<td>
						校区: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_campus" value="<%= customer.getCu_campus() %>" maxlength="4">
					</td>
				</tr>
				<tr>
					<td>
						权限: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_authority" value="<%= customer.getCu_authority() %>">
					</td>
					<td>
						QQ: &nbsp;
					</td>
					<td>
						<input disabled="disabled" type="text" class="cu_qq" value="<%= customer.getCu_qq() %>" maxlength="11"
						onkeyup="this.value=this.value.replace(/\D/g,'')">
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="button" class="button1" value="修改">
						<input type="button" class="button2" value="返回">
					</td>
				</tr>
			</table>
			<form class="file" id="file" enctype="multipart/form-data" style="display: none;">
				<input class="file1" id="file1" name="file1" accept=".png, .jpg" type="file" style="display: none;">
			</form>
		<% } else {%>
			无此用户信息
		<% } %>
	</div>
	<%@ include file="bottom.jsp" %>
</body>
</html>