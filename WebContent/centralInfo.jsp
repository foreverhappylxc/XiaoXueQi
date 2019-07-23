<%@page import="entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<body>
	<%@ include file="top.jsp" %>
	<div align="center">
		<% if (request.getAttribute("userIno") != null) {%>
			<% Customer customer = (Customer)request.getAttribute("userIno"); %>
			<table>
				<tr>
					<td>
						cu_id: &nbsp; <input type="text" class="cu_id" value="<%= customer.getCu_id() %>">
					</td>
				</tr>
			</table>
		<% } else {%>
			无此用户信息
		<% } %>
	</div>
	<%@ include file="bottom.jsp" %>
</body>
</html>