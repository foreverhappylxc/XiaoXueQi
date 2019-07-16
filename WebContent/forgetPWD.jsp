<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
<link href="css/forgetPWD2.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="div1" id="div1"></div>
	<form action="mSuccess.jsp" name="form1" id="form1" method="post">
		<div class="div2" id="div2">id：</div>
		<input type="text" name="email" id="email" placeholder="输入id,后向你注册邮箱发送验证码">
		<button id="b" class="b" name="b">发送</button>
		<div class="div3" id="div3">验证码：</div>
		<input type="text" name="scode" id="scode" placeholder="输入邮件中的验证码">
		<div class="div4" id="div4">新密码：</div>
		<input type="text" name="npwd" id="npwd" placeholder="输入新密码">
		<input type="submit" name="submit" id="submit" value="确定">
	</form>
	<form action="teacherLogIn.jsp" name="form2" id="form2" method="post">
		<input type="submit" name="cancel" id="cancel" value="取消">
	</form>
</body>
</html>