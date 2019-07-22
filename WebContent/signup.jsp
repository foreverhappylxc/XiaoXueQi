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
	<!-- //js -->
	<!-- web-fonts -->   
	<link href="http://fonts.googleapis.com/css?family=Berkshire+Swash" rel="stylesheet"> 
	<link href="http://fonts.googleapis.com/css?family=Yantramanav:100,300,400,500,700,900" rel="stylesheet">
	<!-- //web-fonts -->
	<title>注册</title>
</head>
<body>
       <%@ include file="top.jsp"  %>
	<div class="container">	
		<ol class="breadcrumb w3l-crumbs">
			<li><a href="#"><i class="fa fa-home"></i> 主页</a></li> 
			<li class="active">注册</li>
		</ol>
	</div>
	<div class="login-page about">
		<div class="container"> 
			<h3 class="w3ls-title w3ls-title1">注册你的账户</h3>  
			<div class="login-agileinfo"> 
				<form action="RegisterServlet" method="post"> 
					<input class="agile-ltext" type="text" name="UserID" placeholder="学号"  required>
					<input class="agile-ltext" type="text" name="Username" placeholder="姓名"  required>
					<input class="agile-ltext" type="text" name="UsernameNick" placeholder="昵称"  required><br />
					性别：<select name="Sex">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
					<input class="agile-ltext" type="email" name="Email" placeholder="邮箱"  required>
					<input class="agile-ltext" type="text" name="QQ" placeholder="qq"  required><br />
					校区：<select name="Campus">
						<option value="江安校区">江安校区</option>
						<option value="华西校区">华西校区</option>
						<option value="望江校区">望江校区</option>
					</select>
					<input class="agile-ltext" type="password" name="Password" placeholder="密码"  required>
					<input class="agile-ltext" type="password" name="ConfirmPassword" placeholder="确认密码"  required>
					<div class="wthreelogin-text"> 
						<ul> 
							<li>
								<label class="checkbox"><input type="checkbox" name="checkbox"><i></i> 
									<span>我已详细阅读并同意用户指南</span> 
								</label> 
							</li> 
						</ul>
						<div class="clearfix"> </div>
					</div>   
					<input type="submit" value="注册">
				</form>
				<p>已有账户？  <a href="login.jsp"> 登录！</a></p> 
			</div>	 
		</div>
	</div>
	<!-- //sign up-page -->  
	 <%@ include file="bottom.jsp"  %>
	<!-- cart-js -->
	<script src="js/minicart.js"></script>
	<script>
        w3ls.render();

        w3ls.cart.on('w3sb_checkout', function (evt) {
        	var items, len, i;

        	if (this.subtotal() > 0) {
        		items = this.items();

        		for (i = 0, len = items.length; i < len; i++) { 
        		}
        	}
        });
    </script>  
	<!-- //cart-js -->	
	<!-- start-smooth-scrolling -->
	<script src="js/SmoothScroll.min.js"></script>  
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>	
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
			
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
	<!-- //end-smooth-scrolling -->	  
	<!-- smooth-scrolling-of-move-up -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<!-- //smooth-scrolling-of-move-up --> 
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>
</html>