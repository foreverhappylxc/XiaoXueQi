<%@page import="myJavaBean.Grade"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改成绩</title>
<link href="css/findTeaches.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
$.ajax({
	type: "post",
	url: "FindTeaches",
	data: {
		"id": <%= (String)request.getSession().getAttribute("id2") %>
	},
	dataType: "json",
	success: function(response,status,xhr) {
		for (i in response)
			{
			$("#dept_name").append("<option>" + response[i].course_id + " " +response[i].course_name + " "
					+ response[i].course_order + " " + response[i].year + " " + response[i].season + "</option>");
			}
		},
	error: function(xhr, status, errMsg) {
		
		}
	}	
);
var n;
var click = false;

function clicked1(i)
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
		
		for (j = 9; j < t.length - 1; j++)
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
			url: "ModifyGrade",
			data: {
				"id": t[0].innerText,
				"course_id": t[2].innerText,
				"course_order": t[4].innerText,
				"year": t[5].innerText,
				"season": t[6].innerText,
				"grade": t[9].innerText
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
		for (j = 9; j < 10; j++)
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
			for (j = 9; j < t.length - 1; j++)
				{
				var txtValue = document.getElementById("text" + n + j).value;
				t[j].innerText = txtValue;
				}
			}
		}
}
</script>
</head>
<body>
<jsp:include page="teacherTop.jsp"></jsp:include>
	<div class="div11">
	<form action="FindGrade" method="get">
		<select name="dept_name" id="dept_name"
			onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
			
		</select>
		<input type="submit" name="search" id="search" value="搜索">
	</form>
	</div>
	<div class="div10">
		<table id="table1" class="table1" onmouseup="mouseup();">
			<tr>
				<td align="left" width="225">
					学生号
				</td>
				<td align="left" width="225">
					学生名
				</td>
				<td align="left" width="225">
					课程号
				</td>
				<td align="left" width="225">
					课程名
				</td>
				<td align="left" width="225">
					课序号
				</td>
				<td align="left" width="225">
					年份
				</td>
				<td align="left" width="225">
					学期
				</td>
				<td align="left" width="225">
					系名
				</td>
				<td align="left" width="225">
					学分
				</td>
				<td align="left" width="225">
					成绩
				</td>
				<td>
				</td>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				List<Grade> list = (List<Grade>)request.getAttribute("list");
				int i=0;
				if (list != null) {
				for (Grade t: list)
				{
					i++;
			%>
				<tr class=<%= "tr" + i %> id=<%= "tr" + i %>>
					<td class=<%= "class" + i %> id=<%= "id" + i %> align="left" width="225">
						<%= t.getID() %>
					</td>
					<td class=<%= "class" + i + "a" %> id=<%= "id" + i + "a" %> align="left" width="225">
						<%= t.getName() %>
					</td>
					<td class=<%= "class" + i + "b" %> id=<%= "id" + i + "b" %> align="left" width="100">
						<%= t.getCourse_id() %>
					</td>
					<td class=<%= "class" + i + "c" %> id=<%= "id" + i + "c" %> align="left" width="225">
						<%= t.getCourse_name() %>
					</td>
					<td class=<%= "class" + i + "d" %> id=<%= "id" + i + "d" %> align="left" width="225">
						<%= t.getCourse_order() %>
					</td>
					<td class=<%= "class" + i + "e" %> id=<%= "id" + i + "e" %> align="left" width="225">
						<%= t.getYear() %>
					</td>
					<td class=<%= "class" + i + "f" %> id=<%= "id" + i + "f" %> align="left" width="225">
						<%= t.getSeason() %>
					</td>
					<td class=<%= "class" + i + "g" %> id=<%= "id" + i + "g" %> align="left" width="225">
						<%= t.getDept_name() %>
					</td>
					<td class=<%= "class" + i + "h" %> id=<%= "id" + i + "h" %> align="left" width="225">
						<%= t.getCredits() %>
					</td>
					<td class=<%= "class" + i + "h" %> id=<%= "id" + i + "h" %> align="left" width="225">
						<%= t.getGrade() %>
					</td>
					<td align="center" width="100">
					<a class=<%= "a" + i %> id=<%= "a" + i %> href="">
							<button class=<%= "b" + i %> id=<%= "b" + i %> name=<%= "b" + i %> onclick="return clicked1(<%= i %>)"
							style="width: 45px;">
								修改
							</button>
					</a>
					</td>
				</tr>
			<%
				}
			%>
			<%
				}
			%>
			<tr>
				<td align="center" colspan="11">
					<%= request.getAttribute("bar") %>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>