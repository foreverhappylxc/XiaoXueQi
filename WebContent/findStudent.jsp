<%@page import="myJavaBean.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查看学生</title>
<link href="css/findStudent.css" rel="stylesheet" type="text/css">
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
			url: "UpdateStudent",
			data: {
				"id": t[0].innerText,
				"id_card": t[1].innerText,
				"password": t[2].innerText,
				"name": t[3].innerText,
				"sex": t[4].innerText,
				"address": t[5].innerText,
				"telephone": t[6].innerText,
				"class_id": t[7].innerText,
				"enrollment_time": t[8].innerText,
				"dept_name": t[9].innerText,
				"major": t[10].innerText,
				"birthday": t[11].innerText,
				"total_cred": t[12].innerText
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
		for (j = 1; j < 13; j++)
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
	url: "DeleteStudent",
	data: {
		"id": t[0].innerText,
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
	<form action="Student" method="get">
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
					学生号
				</td>
				<td align="left" width="225">
					身份证
				</td>
				<td align="left" width="100">
					密码
				</td>
				<td align="left" width="225">
					姓名
				</td>
				<td align="left" width="50">
					性别
				</td>
				<td align="left" width="225">
					地址
				</td>
				<td align="left" width="225">
					电话号码
				</td>
				<td align="left" width="225">
					班级号
				</td>
				<td align="left" width="225">
					入学时间
				</td>
				<td align="left" width="225">
					系名
				</td>
				<td align="left" width="225">
					专业
				</td>
				<td align="left" width="225">
					生日
				</td>
				<td align="left" width="225">
					总学分
				</td>
				<td>
				</td>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				List<Student> list = (List<Student>)request.getAttribute("list");
				int i=0;
				if (list != null) {
				for (Student t: list)
				{
					i++;
			%>
				<tr class=<%= "tr" + i %> id=<%= "tr" + i %>>
					<td class=<%= "class" + i %> id=<%= "id" + i %> align="left" width="225">
						<%= t.getId() %>
					</td>
					<td class=<%= "class" + i + "a" %> id=<%= "id" + i + "a" %> align="left" width="225">
						<%= t.getId_card() %>
					</td>
					<td class=<%= "class" + i + "b" %> id=<%= "id" + i + "b" %> align="left" width="100">
						<%= t.getPassword() %>
					</td>
					<td class=<%= "class" + i + "c" %> id=<%= "id" + i + "c" %> align="left" width="225">
						<%= t.getName() %>
					</td>
					<td class=<%= "class" + i + "d" %> id=<%= "id" + i + "d" %> align="left" width="50">
						<%= t.getSex() %>
					</td>
					<td class=<%= "class" + i + "e" %> id=<%= "id" + i + "e" %> align="left" width="225">
						<%= t.getAddress() %>
					</td>
					<td class=<%= "class" + i + "f" %> id=<%= "id" + i + "f" %> align="left" width="225">
						<%= t.getTelephone() %>
					</td>
					<td class=<%= "class" + i + "g" %> id=<%= "id" + i + "g" %> align="left" width="225">
						<%= t.getClass_id() %>
					</td>
					<td class=<%= "class" + i + "h" %> id=<%= "id" + i + "h" %> align="left" width="225">
						<%= t.getEnrollment_time() %>
					</td>
					<td class=<%= "class" + i + "i" %> id=<%= "id" + i + "i" %> align="left" width="225">
						<%= t.getDept_name() %>
					</td>
					<td class=<%= "class" + i + "j" %> id=<%= "id" + i + "j" %> align="left" width="225">
						<%= t.getMajor() %>
					</td>
					<td class=<%= "class" + i + "k" %> id=<%= "id" + i + "k" %> align="left" width="225">
						<%= t.getBirthday() %>
					</td>
					<td class=<%= "class" + i + "l" %> id=<%= "id" + i + "l" %> align="left" width="225">
						<%= t.getTotal_cred() %>
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