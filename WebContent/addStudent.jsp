<%@page import="myJavaBean.ID"%>
<%@page import = "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加学生</title>
<link href="css/addStudent.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/addStudent.js">
</script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	function clicked()
	{
		var selected = $("#dept_name").val();
		var selection = document.getElementById("major");
		selection.innerHTML = "";
		$.ajax({
			type: "get",
			url: "AddStudent",
			data: {
			},
			dataType: "json",
			success: function(response,status,xhr) {
				for (j in response)
					{
					if (selected == response[j].dept_name)
						{
					$("#major").append("<option>" + response[j].name + "</option>");
						}
					}
				},
			error: function(xhr, status, errMsg) {
				
				}
			}	
		);
	}		
</script>
</head>
<body>
	<jsp:include page="managerTop.jsp"></jsp:include>
	<form action="AddStudent" method="post" name="form1" id="form1" onsubmit="return reg(this);">
		<div class="div10">
			学号：
		</div>
		<input type="text" name="id" id="id" value="<%= (String)request.getSession().getAttribute("id1") %>" maxlength="13"
		onkeyup="this.value=this.value.replace(/\D/g,'')">
		<div class="div11">
			身份证：
		</div>
		<input type="text" name="id_card" id="id_card" value="<%= (String)request.getSession().getAttribute("id1") %>" maxlength="18"
		onkeyup="this.value=this.value.replace(/\D/g,'')">
		<div class="div12">
			密码：
		</div>
		<input type="text" name="password" id="password" value="123456" maxlength="15">
		<div class="div13">
			姓名：
		</div>
		<input type="text" name="name" id="name" placeholder="输入学生姓名" maxlength="15">
		<div class="div14">
			性别：
		</div>
		<input type="radio" name="sex" class="man" id="man" value="男">	
		<div class="sex1">男</div>
		<input type="radio" name="sex" class="woman" id="woman" value="女"> 
		<div class="sex2">女</div>
		<div class="div15">
			住址：
		</div>
		<input type="text" name="address" id="address" placeholder="输入学生家庭住址" maxlength="30">
		<div class="div16">
			电话号码：
		</div>
		<input type="text" name="telephone" id="telephone" placeholder="输入学生联系电话号码" maxlength="11"
		onkeyup="this.value=this.value.replace(/\D/g,'')">
		<div class="div17">
			班级号：
		</div>
		<input type="text" name="class_id" id="class_id" placeholder="输入学生班级号码" maxlength="9"
		onkeyup="this.value=this.value.replace(/\D/g,'')">
		<div class="div18">
			入学时间：
		</div>
		<input type="date" name="enrollment_time" id="enrollment_time">
		<div class="div19">
			系名：
		</div>
		<select name="dept_name" id="dept_name"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0" onclick="clicked();">
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
		<div class="div20">
			专业：
		</div>
		<select name="major" id="major"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
			
		</select>
		<div class="div21">
			生日：
		</div>
		<input type="date" name="birthday" id="birthday">
		<input type="submit" name="submit" id="submit" value="提交">
	</form>
	<a class="can" id="can" href="managerHome.jsp">
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