<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import = "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加课程</title>
<link href="css/addCourse.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/addCourse.js">
</script>
<script type="text/javascript" src="js/addSection.js">
</script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	function clicked()
	{
		var selected = $("#ci").val();
		var selection = document.getElementById("cn");
		var selection1 = document.getElementById("dn");
		var selection2 = document.getElementById("c");
		selection.innerHTML = "";
		selection1.innerHTML = "";
		selection2.innerHTML = "";
		$.ajax({
			type: "get",
			url: "AddSection",
			data: {
			},
			dataType: "json",
			success: function(response,status,xhr) {
				for (j in response)
					{
					if (selected == response[j].course_id)
						{
						$("#cn").append("<option>" + response[j].course_name + "</option>");
						$("#dn").append("<option>" + response[j].dept_name + "</option>");
						$("#c").append("<option>" + response[j].credits + "</option>");
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
	<form action="AddCourse" method="post" name="form1" id="form1" onsubmit="return reg1(this);">
		<div class="div10">
			课程号：
		</div>
		<input type="text" name="course_id" id="course_id" placeholder="输入课程号" maxlength="9">
		<div class="div11">
			课程名：
		</div>
		<input type="text" name="course_name" id="course_name" placeholder="输入课程名" maxlength="30">
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
			学分：
		</div>
		<select name="credits" id="credits"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		</select>
		<input type="submit" name="submit" id="submit" value="添加">
	</form>
	<%
	if (request.getParameter("success") != null)
	{
	%>
	<script type="text/javascript">
	if (<%=request.getParameter("success")%>)
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
	<hr>
	<form action="AddSection" method="post" name="form2" id="form2" onsubmit="return reg(this);">
	<div class="div14">
			课程号：
		</div>
		<select name="ci" id="ci"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0" onclick="clicked();">
		<%
				@SuppressWarnings("unchecked")
				List<String> list1 = (List<String>) request.getAttribute("list1");
				try
				{
					for (String s: list1)
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
		<div class="div15">
			课程名：
		</div>
		<select name="cn" id="cn"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
		</select>
		<div class="div16">
			系名：
		</div>
		<select name="dn" id="dn"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
		</select>
		<div class="div17">
			学分：
		</div>
		<select name="c" id="c"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
		</select>
		<div class="div18">
			课序号：
		</div>
		<input type="text" name="course_order" id="course_order" placeholder="输入课序号" maxlength="1"
		onkeyup="this.value=this.value.replace(/\D/g,'')">
		<div class="div19">
			年份：
		</div>
		<select name="year" id="year"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
		<option>2014</option>
		<option>2015</option>
		<option>2016</option>
		<option>2017</option>
		</select>
		<div class="div20">
			学期：
		</div>
		<select name="season" id="season"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
		<option>春</option>
		<option>夏</option>
		<option>秋</option>
		<option>冬</option>
		</select>
		<div class="div21">
			课节数：
		</div>
		<select name="time" id="time"
		onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
		<option>2</option>
		<option>3</option>
		<option>4</option>
		</select>
		<div class="div22">
			课容量：
		</div>
		<input type="text" name="mount" id="mount" placeholder="课容量" maxlength="3"
		onkeyup="this.value=this.value.replace(/\D/g,'')">
		<input type="submit" name="s" id="s" value="提交">
	</form>
	<a class="can" href="managerHome.jsp">
		<button name="cancel" id="cancel">
			取消
		</button>
	</a>
	<%
	if (request.getParameter("success1") != null)
	{
	%>
	<script type="text/javascript">
	if (<%=request.getParameter("success1")%>)
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