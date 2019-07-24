<%@page import="java.util.ArrayList"%>
<%@page import="entity.Task"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>全部悬赏</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/about1.css">
</head>
<body>
	<%@ include file="top.jsp"%>
	<!-- To do your work  -->
	<div class="top4" id="top4">
			<form action="SearchAbout" method="post">
				<input type="text" class="keyword" name="keyword" id="keyword" placeholder="输入查询关键字" maxlength="20">
				<select class="select1" name="t_class" id ="t_class">
					<option value="跑腿">
						跑腿
					</option>
					<option value="组队">
						组队
					</option>
					<option value="交易">
						交易
					</option>
					<option value="求助">
						求助
					</option>
					<option value="其它">
						其它
					</option>
				</select>
				<select class="select2" name="t_campus" id="t_campus">
					<option value="江安校区">
						江安校区
					</option>
					<option value="望江校区">
						望江校区
					</option>
					<option value="华西校区">
						华西校区
					</option>
				</select>
				<input class="search" type="submit" value="搜索">
			</form>
		</div>
		<div class="content">
		<div class="right">
			<div class="filter">
				<div>
					<span>时间</span>
					<select>
						<option value="升序">升序</option>
						<option value="降序">降序</option>
					</select>
				</div>
				<div>
					<span>难度</span>
					<select>
						<option value="困难">困难</option>
						<option value="中等">中等</option>
						<option value="简单">简单</option>
					</select>
				</div>
			</div>
			<div class="xxx">
			</div>
			<div class="txt">
				<div class="result">
					<div class="rLeft">
						<% if(request.getAttribute("list") !=null && request.getAttribute("list") !="") {
						ArrayList<Task> list= (ArrayList<Task>)request.getAttribute("list");
						for(Task task:list){%>
						<div class="result1">
							<h4><%= task.getT_title() %></h4>
						</div>
						<div class="result2">
							<%= task.getT_content() %>
						</div>
						<div class="result3">
							<span>
								<%= task.getT_class() %>
							</span>
							<span>
								<%= task.getP_btime() %>
							</span>
							<span>
								<%= task.getT_class() %>
							</span>
							<span>
								<%= task.getT_rank() %>
							</span>
						</div>
						<%}}else { %>
						无数据
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="bottom.jsp"%>
</body>
</html>