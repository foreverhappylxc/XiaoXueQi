<%@page import="myJavaBean.Section"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查看学生</title>
<link href="css/findSection.css" rel="stylesheet" type="text/css">
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
		
		for (j = 5; j < t.length - 1; j++)
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
			url: "UpdateSection",
			data: {
				"course_id": t[0].innerText,
				"course_order": t[4].innerText,
				"year": t[5].innerText,
				"season": t[6].innerText,
				"time": t[7].innerText,
				"mount": t[8].innerText,
				"room_no": t[9].innerText,
				"time_no": t[10].innerText,
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
		for (j = 5; j < 11; j++)
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
			for (j = 5; j < t.length - 1; j++)
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
	url: "DeleteSection",
	data: {
		"course_id": t[0].innerText,
		"course_order": t[4].innerText,
		"year": t[5].innerText,
		"season": t[6].innerText
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
	<form action="Section" method="get">
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
		<table id="table1" class="table1" onmouseup="mouseup();">
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
				<td align="left" width="50">
					学分
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
					时长
				</td>
				<td align="left" width="225">
					课容量
				</td>
				<td align="left" width="225">
					房间号
				</td>
				<td align="left" width="225">
					时间号
				</td>
				<td align="left" width="225">
					教师姓名
				</td>
				<td>
				</td>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				List<Section> list = (List<Section>)request.getAttribute("list");
				int i=0;
				if (list != null) {
				for (Section t: list)
				{
					i++;
			%>
				<tr class=<%= "tr" + i %> id=<%= "tr" + i %>>
					<td class=<%= "class" + i %> id=<%= "id" + i %> align="left" width="225">
						<%= t.getCourse_id() %>
					</td>
					<td class=<%= "class" + i + "a" %> id=<%= "id" + i + "a" %> align="left" width="225">
						<%= t.getCourse_name() %>
					</td>
					<td class=<%= "class" + i + "b" %> id=<%= "id" + i + "b" %> align="left" width="100">
						<%= t.getDept_name() %>
					</td>
					<td class=<%= "class" + i + "c" %> id=<%= "id" + i + "c" %> align="left" width="225">
						<%= t.getCredits() %>
					</td>
					<td class=<%= "class" + i + "d" %> id=<%= "id" + i + "d" %> align="left" width="50">
						<%= t.getCourse_order() %>
					</td>
					<td class=<%= "class" + i + "e" %> id=<%= "id" + i + "e" %> align="left" width="225">
						<%= t.getYear() %>
					</td>
					<td class=<%= "class" + i + "f" %> id=<%= "id" + i + "f" %> align="left" width="225">
						<%= t.getSeason() %>
					</td>
					<td class=<%= "class" + i + "g" %> id=<%= "id" + i + "g" %> align="left" width="225">
						<%= t.getTime() %>
					</td>
					<td class=<%= "class" + i + "h" %> id=<%= "id" + i + "h" %> align="left" width="225">
						<%= t.getMount() %>
					</td>
					<td class=<%= "class" + i + "i" %> id=<%= "id" + i + "i" %> align="left" width="225">
						<%= t.getRoom_no() %>
					</td>
					<td class=<%= "class" + i + "j" %> id=<%= "id" + i + "j" %> align="left" width="225">
						<%= t.getTime_no() %>
					</td>
					<td align="center" width="100">
					<a class=<%= "a" + i %> id=<%= "a" + i %> href="">
							<button class=<%= "b" + i %> id=<%= "b" + i %> name=<%= "b" + i %> onclick="return clicked(<%= i %>)"
							style="width: 45px;">
								修改
							</button>
					</a>
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
				<td align="center" colspan="14">
					<%= request.getAttribute("bar") %>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>