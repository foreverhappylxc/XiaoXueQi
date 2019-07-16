<%@page import="myJavaBean.Course"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查看课程</title>
<link href="css/findCourse.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
$.ajax({
	type: "post",
	url: "FindDepartment",
	data: {
	},
	dataType: "json",
	success: function(response,status,xhr) {
		for (i in response)
			{
			$("#dept_name").append("<option>" + response[i].dept_name + "</option>");
			}
		},
	error: function(xhr, status, errMsg) {
		
		}
	}	
);
var n;
var click = false;

function clicked(i)
{
	var b = document.getElementById("b" + i);
	var a = document.getElementById("a" + i);
	var t = document.getElementById("tr" + i).children;
	
	n = i;
	if (b.innerText == "修改")
		{
		b.innerText = "保存";
		var height = t[0].offsetHeight;
		click = true;
		
		for (j = 1; j < t.length - 1; j++)
			{
			var width = t[j].width;
			var tdValue = t[j].innerText;
			var txt = document.createElement("textarea");
			txt.id = "text" + i + j;
			txt.style.width = width + "px";
			txt.style.height = height + "px";
			txt.style.resize = "none";
			txt.style.fontSize = "15px";
			t[j].innerText = "";
			txt.value = tdValue;
			t[j].appendChild(txt);
			}
		return false;
		}
	else {
		if (b.innerText == "保存") {	
		$.ajax({
			type: "post",
			url: "UpdateCourse",
			data: {
				"course_id": t[0].innerText,
				"course_name": t[1].innerText,
				"dept_name": t[2].innerText,
				"credits": t[3].innerText
			},
			dataType: "json",
			success: function(response,status,xhr) {
				b.innerText = "修改";
				if (response[0].success == true)
					{
					alert("修改成功！");
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
}
}
function mouseup()
{
if (click)
	{
	var b = false;
	click = false;
	for (j = 1; j < 4; j++)
		{
		if (document.getElementById("text" + n + j) && event.srcElement.id == "text" + n + j)
			{
			b = true;
			click = true;
			break;
			}
		}
	if (!b)
		{
		var t = document.getElementById("tr" + n).children;
		for (j = 1; j < t.length - 1; j++)
			{
			var txtValue = document.getElementById("text" + n + j).value;
			t[j].innerText = txtValue;
			}
		}
	}
}

function clicked1(i)
{
var t = document.getElementById("tr" + i).children;
$.ajax({
	type: "post",
	url: "DeleteCourse",
	data: {
		"course_id": t[0].innerText,
	},
	dataType: "json",
	success: function(response,status,xhr) {
		if (response[0].success == true)
			{
			document.getElementById("tr" + i).innerText = "";
			alert("删除成功！");
			}
		else 
			{
			alert("删除失败！");
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
	<jsp:include page="managerTop.jsp"></jsp:include>
	<div class="div11">
	<form action="Course" method="get">
		<select name="dept_name" id="dept_name"
			onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
			<option>
			所有
			</option>
		</select>
		<input type="submit" name="search" id="search" value="搜索">
	</form>
	</div>
	<div class="div10">
		<table id="table1" class="table1" onmouseup="mouseup()">
			<tr>
				<td align="left" width="225">
					课程号
				</td>
				<td align="left" width="225">
					课程名
				</td>
				<td align="left" width="225">
					系名
				</td>
				<td align="left" width="225">
					学分
				</td>
				<td>
				</td>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				List<Course> list = (List<Course>)request.getAttribute("list");
				int i=0;
				if (list != null) {
				for (Course d: list)
				{
					i++;
			%>
				<tr class=<%= "tr" + i %> id=<%= "tr" + i %>>
					<td class=<%= "class" + i %> id=<%= "id" + i %> align="left" width="225">
						<%= d.getCourse_id() %>
					</td>
					<td class=<%= "class" + i + "a" %> id=<%= "id" + i + "a" %> align="left" width="225">
						<%= d.getCourse_name() %>
					</td>
					<td class=<%= "class" + i + "b" %> id=<%= "id" + i + "b" %> align="left" width="225">
						<%= d.getDept_name() %>
					</td>
					<td class=<%= "class" + i + "c" %> id=<%= "id" + i + "c" %> align="left" width="225">
						<%= d.getCredits() %>
					</td>
					<td align="center" width="100">
					<span>
						<a class=<%= "a" + i %> id=<%= "a" + i %> href="">
							<button class=<%= "b" + i %> id=<%= "b" + i %> name=<%= "b" + i %> onclick="return clicked(<%= i %>)"
							style="width: 45px;">
								修改
							</button>
						</a>
					</span>
					<span>
						<a>
							<button onclick="return clicked1(<%= i %>)" style="width: 45px;">
								删除
							</button>
						</a>
					</span>
					</td>
				</tr>
			<%
				}
			%>
			<%
				}
			%>
			<tr>
				<td align="center" colspan="5">
					<%= request.getAttribute("bar") %>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>