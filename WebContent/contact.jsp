<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>发布任务</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
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
	<script src="js/layDate/laydate/laydate.js"></script> 
	<script>
    laydate.render({
        elem: '#date1' //指定元素
    });
    laydate.render({
        elem: '#date2' //指定元素
    });
</script>
	<!-- //js -->
	<!-- web-fonts -->   
	<link href="http://fonts.googleapis.com/css?family=Berkshire+Swash" rel="stylesheet"> 
	<link href="http://fonts.googleapis.com/css?family=Yantramanav:100,300,400,500,700,900" rel="stylesheet">
	<!-- //web-fonts -->
</head>
<body>
	<%@ include file="top.jsp"%>
	<div class="login-page about">
		<div class="container"> 
			<h3 class="w3ls-title w3ls-title1">发布任务</h3>  
			<div class="login-agileinfo"> 
				<form action="RegisterServlet" method="post"> 
					<input class="agile-ltext" type="text" name="TaskTitle" placeholder="任务名称"  required>
					<input class="agile-ltext" type="text" name="TaskCount" placeholder="所需人数"  required><br />
					
                   <div class="form-group">
                         <label>请选择截至日期</label><br/>
                         <input type="text" id='date1' name="accountTime1">
                   </div> 
                   <script>laydate.render({elem: '#date1'  });</script>
                                                        任务难度：<select name="Level">
                        <option value="低">低</option>
						<option value="中">中</option>
						<option value="高">高</option>
					</select>
					任务校区：<select name="Campus">
						<option value="江安校区">江安校区</option>
						<option value="华西校区">华西校区</option>
						<option value="望江校区">望江校区</option>
					</select>
					<input class="agile-ltext" type="text" name="comment" placeholder="请在此输入任务详细描述"  required><br />
					<div class="wthreelogin-text"> 						  
					<input type="submit" value="发布任务">
					</div>
				</form>
			</div>	 
		</div>
	</div>
	<%@ include file="bottom.jsp"%>
	<script src="js/SmoothScroll.min.js"></script>  
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript"></script>
	<script type="text/javascript">response.sendRedirect("./about.jsp");</script>  <!--用于跳转至详情页面-->


</body>
</html>