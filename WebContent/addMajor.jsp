<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import = "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加专业</title>
<link href="css/addMajor.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/addMajor.js">
</script>
</head>
<body>
	<jsp:include page="managerTop.jsp"></jsp:include>
	<form action="AddMajor" method="post" name="form1" id="form1" onsubmit="return reg(this);">
		<div class="div10">
			专业号：
		</div>
		<input type="text" name="id" id="id" placeholder="输入专业号" maxlength="13"
		onkeyup="this.value=this.value.replace(/\D/g,'')">
		<div class="div11">
			专业名：
		</div>
		<input type="text" name="name" id="name" placeholder="输入专业名" maxlength="30">
		<div class="div12">
			系名：
		</div>
		<select name="dept_name" id="dept_name"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
			<%
				@SuppressWarnings("unchecked") 
				List<String> list = (List<String>) request.getAttribute("list");
				try
				{
					for (String s: list)
					{
			%>
				<option>
					<%= s %>
				</option>
			<%
					}
				} catch (Exception e)
				{
					
				}
			%>
		</select>
		<div class="div13">
			管理者：
		</div>
		<input type="text" name="manager" id="manager" placeholder="输入一名管理员" maxlength="15">
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