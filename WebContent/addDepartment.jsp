<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加学院</title>
<link href="css/addDepartment.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/addDepartment.js">
</script>
</head>
<body>
	<jsp:include page="managerTop.jsp"></jsp:include>
	<form action="AddDepartment" method="post" name="form1" id="form1" onsubmit="return reg(this);">
		<div class="div10">
			学院名：
		</div>
		<input type="text" name="dept_name" id="dept_name" placeholder="输入学院名称" maxlength="30">
		<div class="div11">
			学院建筑名：
		</div>
		<input type="text" name="building" id="building" placeholder="输入学院建筑" maxlength="15">
		<div class="div12">
			院长名：
		</div>
		<input type="text" name="president" id="president" placeholder="输入院长名" maxlength="15">
		<div class="div13">
			副院长名：
		</div>
		<input type="text" name="vice_president" id="vice_president" placeholder="输入副院长名" maxlength="15">
		<div class="div14">
			描述：
		</div>
		<textarea rows="10" cols="20" name="description" id="description" placeholder="在此输入对于学院的描述，少于200个字" maxlength="200"></textarea>
		<input type="submit" name="submit" id="submit" value="提交">
	</form>
	<a href="managerHome.jsp">
		<button name="cancel" id="cancel">
			取消
		</button>
	</a>
	<%
	if (request.getAttribute("success") != null)
	{
	%>
	<script type="text/javascript">
	if (<%=request.getAttribute("success")%>)
		{
		alert("添加成功");
		}
	else
		{
		alert("添加失败");
		}
	</script>
	<%
	}
	%>
</body>
</html>