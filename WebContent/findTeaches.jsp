<%@page import="myJavaBean.Takes"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查看课表</title>
<link href="css/findTeache.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<body>
	<jsp:include page="teacherTop.jsp"></jsp:include>
	<div class="div11">
	<form action="SearchTeaches" method="post">
		<select name="year" id="year"
			onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
			<option>2014</option>
			<option>2015</option>
			<option>2016</option>
			<option>2017</option>
		</select>
		<select name="season" id="season"
			onmousedown="if(this.options.length>3){this.size=10}" onblur="this.size=0" onchange="this.size=0">
			<option>春</option>
			<option>夏</option>
			<option>秋</option>
			<option>冬</option>
		</select>
		<input type="hidden" name="id" id="id" value=<%= (String)request.getSession().getAttribute("id2") %>>
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
					课序号
				</td>
				<td align="left" width="225">
					时间
				</td>
				<td align="left" width="225">
					教室
				</td>
				<td align="left" width="225">
					学分
				</td>
				<td>
				</td>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				List<Takes> list = (List<Takes>)request.getAttribute("list");
				int i=0;
				if (list != null) {
				for (Takes t: list)
				{
					i++;
			%>
				<tr class=<%= "tr" + i %> id=<%= "tr" + i %>>
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
						<%= t.getTime_no() %>
					</td>
					<td class=<%= "class" + i + "f" %> id=<%= "id" + i + "f" %> align="left" width="225">
						<%= t.getRoom_no() %>
					</td>
					<td class=<%= "class" + i + "g" %> id=<%= "id" + i + "g" %> align="left" width="225">
						<%= t.getCredits() %>
					</td>
				</tr>
			<%
				}
			%>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>