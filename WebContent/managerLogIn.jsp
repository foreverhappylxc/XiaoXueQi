<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎教务老师，您！</title>
<link href="css/managerLogIn.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/logIn.js"></script>
</head>
<body>
	<%
		String errorString = (String)request.getAttribute("errorMsg");
		if (errorString == null)
		{
			errorString = "";
		}
	%>
	<div class="div1" id="div1" ></div>
	<div class="div4" id="div4"> <%=errorString %> </div>
	<form action="LogIn" method="post" name="form1" id="form1" onsubmit="reg(this);">
		<div class="div2" id="div2">用户名：</div>
		<input type="text" name="userName" id="userName" placeholder="输入教务员ID">
		<div class="div3" id="div3">密码：</div>
		<input type="password" name="password" id="password" placeholder="输入密码">
		<input type="hidden" name="type" id="type" value="manager">
		<input type="hidden" name="js" id="js" value="true">
		<input type="submit" name="submit" id="submit" value="确定">
	</form>
</body>
</html>