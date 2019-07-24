<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>SCU日常任务悬赏系统</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	var s = ["text2", "text3", "text4", "text5", "text6"]
	function check(s2)
	{
		for (var i = 0; i < s.length; i++)
			{
			if (s2 == s[i])
				return false;
			}
		return true;
	}
	$("a").each(function(){
		$(this).click(function(event){
			if (<%= request.getSession().getAttribute("cu_id") %> == null && check(event.target.className))
				{
				alert("请先登录");
				event.preventDefault();
				window.location.href="login.jsp";
				}
		});
	});
	$(".search").click(function(event){
		if (<%= request.getSession().getAttribute("cu_id") %> == null)
			{
			alert("请先登录");
			event.preventDefault();
			window.location.href="login.jsp";
			}
	});
})
</script>
</head>
<body>
	<div class="top" id="top">
		<div class="top1" id="top1">
			<span id="text1" class="text1">
				四川大学日常任务悬赏系统
			</span>
			<% if (request.getSession().getAttribute("cu_id") == null)
				{%>
			<ul class="list1" id="list1">
				<li>
					<a id="text2" class="text2" href="login.jsp">
						<img class="img1" alt="u1" src="img/u1.png" width="15px" height="11px">
						登录
					</a>
				</li>
				<li>
					<a id="text3" class="text3" href="signup.jsp">
						<img class="img2" alt="u2" src="img/u2.png" width="14px" height="11px">
						注册
					</a>
				</li>
			</ul>
			<%} else { %>
				<ul class="list1">
					<li>
						<a class="text2" href="central.jsp">
							<img class="userImg" alt="<%= session.getAttribute("cu_id") %>" src=<%= "userImage/" + session.getAttribute("cu_id") + ".png" %>>
							<%= request.getSession().getAttribute("cu_nickname")%>
						</a>
					</li>
					<li>
						<a class="text3" href="Exit">
							注销
						</a>
					</li>
				</ul>
			<% }%>
		</div>
		<div class="top2" id="top2">
			<div align="center">
				<span class="SCU">
				SCU
				</span>
				<span class="STHS">学生日常任务悬赏系统</span>
			</div>
			<div class="top2_list">
				<ul>
					<li>
						<a class="text6" href="index.jsp">
							主页
						</a>
					</li>
					<li>
						<a class="text4">
							分类
							<img class="img3" alt="img3" src="img/arrow1.png" width="6px" height="8px">
						</a>
					</li>
					<li>
						<a href="about.jsp">
							全部悬赏
						</a>
					</li>
					<li>
						<a href="central.jsp">
							个人中心
						</a>
					</li>
					<li>
						<a href="contact.jsp">
							发布任务
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="top3" id="top3">
			<h2>
				四川大学<br>
				<span>
					学生日常任务悬赏系统
				</span>
			</h2>
			<form action="SearchAbout" method="post">
				<input type="text" class="keyword" name="keyword" id="keyword" placeholder="输入查询关键字" maxlength="20">
				<select class="select1" name="t_class" id = "t_class">
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
	</div>
	<div class="middle1" id="middle1">
		<span>
			<a class="text5" href="index.jsp">
				<img class="img4" alt="i1" src="img/i1.png" width="16px" height="14px">
				主页
			</a>
		</span>
	</div>
	<div class="middle2" id="middle2" align="center">
		<div class="middle21">
			<a href="about.jsp">
				最新 
				<span class="m21span1">
					悬赏任务
				</span>
				<span class="m21span2">
					完&nbsp;成&nbsp;任&nbsp;务&nbsp;获&nbsp;得&nbsp;奖&nbsp;励
				</span>
				<span class="m21span3">
					立刻接受任务
					<img alt="img5" src="img/i2.png" width="15px" height="14px">
				</span>
			</a>
		</div>
		<div class="middle22">
			<a href="contact.jsp">
				发布
				<span class="m22span1">
					悬赏任务
				</span>
				<span class="m22span2">
					发&nbsp;布&nbsp;任&nbsp;务&nbsp;获&nbsp;得&nbsp;帮&nbsp;助
				</span>
				<span class="m22span3">
					立刻发布任务
					<img alt="img5" src="img/i2.png" width="15px" height="14px">
				</span>
			</a>
		</div>
	</div>
	<div class="middle3" id="middle3" align="center">
		<h3>
			如&nbsp;何&nbsp;发&nbsp;布/领&nbsp;取&nbsp;任&nbsp;务？
		</h3>
		<p>
			有以下四个步骤
		</p>
		<div class="m3d1">
			<div>
				<h5>注册/登录系统</h5>
				<img alt="img6" src="img/i3.png" width="40" height="42">
				<span class="m3d11">1</span>
			</div>
			<div>
				<h5>进行实名认证</h5>
				<img alt="img7" src="img/i4.png" width="40" height="42">
				<span class="m3d12">2</span>
			</div>
			<div>
				<h5>发布/接受任务</h5>
				<img alt="img8" src="img/i5.png" width="40" height="42">
				<span class="m3d13">3</span>
			</div>
			<div>
				<h5>完成任务及评价</h5>
				<img alt="img9" src="img/i6.png" width="40" height="42">
				<span class="m3d14">4</span>
			</div>
		</div>
	</div>
	<div class="middle4" id="middle4">
		<div class="m41">
			<h5>悬赏内容</h5>
			<p>
			在这里，你可以发布任务获得帮助，也可以领取任务帮助他人，一切只为——更好的校园生活。
			</p>
		</div>
		<div class="m42">
			<div class="m421">
				<div class="m4211">
					<a href="about1.jsp">
						跑腿
						<span>代取快递/代领外卖/代购等</span>
					</a>
				</div>
			</div>
			<div class="m422">
				<div class="m4221">
					<a href="about1.jsp">
						组队
						<span>出行/参赛/学习等</span>
					</a>
				</div>
			</div>
			<div class="m423">
				<div class="m4231">
					<a href="about1.jsp">
						交易
						<span>二手买卖/闲置出售/租借等</span>
					</a>
				</div>
			</div>
			<div class="m424">
				<div class="m4241">
					<a href="about1.jsp">
						求助
						<span>生活问题/学习课业/寻人等</span>
					</a>
				</div>
			</div>
			<div class="m425">
				<div class="m4251">
					<a href="about1.jsp">
						其它
						<span>更多问题/更多解决</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="bottom" id="bottom">
		<div class="b1">
			<div>
				团&nbsp;队
				<ul>
					<li><a href="#">关于我们</a></li>
					<li><a href="#">联系我们</a></li>
					<li><a href="#">加入我们</a></li>
				</ul>
			</div>
			<div>
				帮&nbsp;助
				<ul>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">操作指南</a></li>
					<li><a href="#">问题反馈</a></li>
					<li><a href="#">违规术语</a></li>
				</ul>
			</div>
			<div>
				信&nbsp;息
				<ul>
					<li><a href="#">开发人员信息</a></li>
					<li><a href="#">管理员信息</a></li>
					<li><a href="#">网站信息</a></li>
				</ul>
			</div>
			<div>
				分&nbsp;类
				<ul>
					<li><a href="#">跑腿</a></li>
					<li><a href="#">组队</a></li>
					<li><a href="#">交易</a></li>
					<li><a href="#">求助</a></li>
					<li><a href="#">其它</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="type">
		<div>
			类型
			<hr>
			<ul>
				<li>
					<a href="about1.jsp?value=1&con=跑腿">
						跑&nbsp;腿
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=1&con=组队">
						组&nbsp;队
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=1&con=交易">
						交&nbsp;易
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=1&con=求助">
						求&nbsp;助
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=1&con=其它">
						其&nbsp;它
					</a>
				</li>
			</ul>
		</div>
		<div>
			校区
			<hr>
			<ul>
				<li>
					<a href="about1.jsp?value=2&con=江安校区">
						江安校区
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=2&con=华西校区">
						华西校区
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=2&con=望江校区">
						望江校区
					</a>
				</li>
			</ul>
		</div>
		<div>
			难度
			<hr>
			<ul>
				<li>
					<a href="about1.jsp?value=3&con=简单">
						简&nbsp;单
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=3&con=中等">
						中&nbsp;等
					</a>
				</li>
				<li>
					<a href="about1.jsp?value=3&con=困难">
						困&nbsp;难
					</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>