<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css" href="css/top.css">
<script type="text/javascript" src="js/top.js"></script>
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
	<div class="type">
		<div>
			类型
			<hr>
			<ul>
				<li>
					<a href="about1.jsp">
						跑&nbsp;腿
					</a>
				</li>
				<li>
					<a href="about1.jsp">
						组&nbsp;队
					</a>
				</li>
				<li>
					<a href="about1.jsp">
						交&nbsp;易
					</a>
				</li>
				<li>
					<a href="about1.jsp">
						求&nbsp;助
					</a>
				</li>
				<li>
					<a href="about1.jsp">
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
					<a href="about1.jsp">
						江安校区
					</a>
				</li>
				<li>
					<a href="about1.jsp">
						华西校区
					</a>
				</li>
				<li>
					<a href="about1.jsp">
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
					<a href="about1.jsp">
						简&nbsp;单
					</a>
				</li>
				<li>
					<a href="about1.jsp">
						中&nbsp;等
					</a>
				</li>
				<li>
					<a href="about1.jsp">
						困&nbsp;难
					</a>
				</li>
			</ul>
		</div>
	</div>