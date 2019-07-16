<%@page import="myJavaBean.Section"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>选择课程</title>
<link href="css/selectCourse.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
function clicked1(i)
{
var t = document.getElementById("tr" + i).children;
$.ajax({
	type: "post",
	url: "UpdateTeaches",
	data: {
		"id": <%= (String)request.getSession().getAttribute("id2") %>,
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
			alert("选择成功！");
			}
		else 
			{
			alert("选择失败！");
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
	<jsp:include page="teacherTop.jsp"></jsp:include>
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
					<span>
						<a>
							<button onclick="return clicked1(<%= i %>)" style="width: 45px;">
								选择
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