<%@page import="entity.Task" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- Custom Theme files -->
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="css/style.css" type="text/css" rel="stylesheet" media="all">  
	<link href="css/font-awesome.css" rel="stylesheet"> <!-- font-awesome icons --> 
	<!-- //Custom Theme files --> 
	<!-- js -->
	<script src="js/jquery-2.2.3.min.js"></script> 
<title>悬赏内容</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</script>
	<!-- //js -->
	<!-- web-fonts -->   
	<link href="http://fonts.googleapis.com/css?family=Berkshire+Swash" rel="stylesheet"> 
	<link href="http://fonts.googleapis.com/css?family=Yantramanav:100,300,400,500,700,900" rel="stylesheet">
	
</head>
<body>
	<%@ include file="top.jsp"%>
	<div class="login-page about">
		<div class="container"> 
			<h3 class="w3ls-title w3ls-title1">任务详情</h3>  
			
			<% if (request.getAttribute("task") != null) {
			Task task = (Task)request.getAttribute("task");%>
			<table  border="1" align="center">
			<tr>
			<td >任务ID：</td> 
			<td align="center"><%= task.getT_id() %></td>
		    </tr>
		    
		    <tr>
		    <td >用户ID：</td> 
			<td align="center"><%= task.getCu_id() %></td>
		    </tr>
		      
		    <tr>
			<td>任务名：</td> 
			<td align="center"><%= task.getT_title() %></td>
		    </tr> 
		  
		    
		    <tr>
			<td>任务发布时间：</td> 
			<td align="center"><%= task.getP_btime() %></td>
		    </tr>  
		    
			<tr>
			<td>任务截止时间：</td> 
			<td align="center"><%= task.getP_etime() %></td>
		    </tr>
		    
		    <tr>
			<td>任务状态：</td> 
			<td align="center"><%= task.getT_state() %></td>
		    </tr>  
		    
		    <tr>
			<td>任务分类：</td> 
			<td align="center"><%= task.getT_class() %></td>
		    </tr> 
		    
		    <tr>
		    <td>校区：</td> 
			<td align="center"><%= task.getT_campus() %></td>
		    </tr>
		    
		    <tr>
			<td>任务难度：</td> 
			<td align="center"><%= task.getT_rank() %></td>
		    </tr> 
		    
		    <tr>
		    <td>任务人数：</td> 
			<td align="center"><%= task.getT_amount()%></td>
		    </tr>
		    
		    <tr>
		    <td>任务已有人数：</td> 
			<td align="center"><%= task.getT_num()%></td>
		    </tr>
		    
		    <tr>
		    <td>任务内容：</td> 
			<td align="center"><%= task.getT_content()%></td>
		    </tr>
		    
		    <tr>
		    <td>任务悬赏：</td> 
			<td align="center"><%= task.getT_money()%></td>
		    </tr>
		    
			</table>
			<%} else {%>
			无数据
	 	 	<%} %>
		</div>
	</div>

	<%@ include file="bottom.jsp"%>
</body>
</html>