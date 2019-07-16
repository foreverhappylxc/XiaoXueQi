<%@page import="myJavaBean.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>你的信息</title>
</head>
<body>
	<jsp:include page="studentTop.jsp"></jsp:include>
	<% 
	Student student = (Student)request.getAttribute("student");
	%>
	<div class="div10" id="div10" style="position: fixed;top: 300px; left: 600px;">
		<div style="position: absolute;top: 0px;left:0px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			学号：<%= student.getId() %>
		</div>
		<div style="position: absolute;top: 0px;left:400px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			身份证：<%= student.getId_card() %>
		</div>
		<div style="position: absolute;top: 50px;left:0px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			姓名：<%= student.getName() %>
		</div>
		<div style="position: absolute;top: 50px;left:400px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			性别：<%= student.getSex() %>
		</div>
		<div style="position: absolute;top: 100px;left:0px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			地址：<%= student.getAddress() %>
		</div>
		<div style="position: absolute;top: 100px;left:400px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			电话号码：<%= student.getTelephone() %>
		</div>
		<div style="position: absolute;top: 150px;left:0px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			班级：<%= student.getClass_id() %>
		</div>
		<div style="position: absolute;top: 150px;left:400px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			入学时间：<%= student.getEnrollment_time() %>
		</div>
		<div style="position: absolute;top: 200px;left:0px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			学院：<%= student.getDept_name() %>
		</div>
		<div style="position: absolute;top: 200px;left:400px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			专业：<%= student.getMajor() %>
		</div>
		<div style="position: absolute;top: 250px;left:0px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			生日：<%= student.getBirthday() %>
		</div>
		<div style="position: absolute;top: 250px;left:400px;color:rgba(116,163,234,1);font-size:20px;width: 300px;">
			学分：<%= student.getTotal_cred() %>
		</div>
	</div>
</body>
</html>