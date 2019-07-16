<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码</title>
<link href="css/forgetPWD.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/forgetPWD2.js"></script>
<script type="text/javascript">
function clicked1()
{
$.ajax({
	type: "post",
	url: "SendEmail",
	data: {
		"id": $("#email").val()
	},
	dataType: "json",
	success: function(response,status,xhr) {
		if (response[0].success == true)
			{
			alert("发送成功！");
			}
		else 
			{
			alert("用户ID不存在或未填邮箱！");
			}
		},
	error: function(xhr, status, errMsg) {
		
		}
	}	
);
return false;
}
function clicked()
{
$.ajax({
	type: "post",
	url: "ModifyPWD2",
	data: {
		"email": $("#email").val(),
		"scode": $("#scode").val(),
		"npwd": $("#npwd").val()
	},
	dataType: "json",
	success: function(response,status,xhr) {
		if (response[0].success == true)
			{
			alert("修改成功！");
			window.location.href = "teacherLogIn.jsp";
			}
		else 
			{
			alert("修改失败！");
			}
		},
	error: function(xhr, status, errMsg) {
		
		}
	}	
);
return false;
}
</script>
</head>
<body>
	<div class="div1" id="div1"></div>
	<form action="ModifyPWD2" name="form1" id="form1" method="post" onsubmit="return reg(this);">
		<div class="div2" id="div2">id：</div>
		<input type="text" name="email" id="email" placeholder="输入id,后向你注册邮箱发送验证码">
		<div class="div3" id="div3">验证码：</div>
		<input type="text" name="scode" id="scode" placeholder="输入邮件中的验证码">
		<div class="div4" id="div4">新密码：</div>
		<input type="text" name="npwd" id="npwd" placeholder="输入新密码">
		<input type="button" name="submit" id="submit" value="确定" onclick="clicked()">
	</form>
	<button id="b" class="b" name="b" onclick="return clicked1()">发送</button>
	<form action="studentLogIn.jsp" name="form2" id="form2" method="post">
		<input type="submit" name="cancel" id="cancel" value="取消">
	</form>
</body>
</html>