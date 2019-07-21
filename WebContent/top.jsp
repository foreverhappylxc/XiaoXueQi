<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="top" id="top">
	<div class="top1" id="top1">
		<span id="text1" class="text1">
			四川大学日常任务悬赏系统
		</span>
		<% if (request.getSession().getAttribute("username") == null)
			{%>
		<ul class="list1" id="list1">
			<li>
				<a id="text2" class="text2" href="#">
					<img class="img1" alt="u1" src="img/u1.png" width="15px" height="11px">
					登录
				</a>
				</li>
			<li>
				<a id="text3" class="text3" href="#">
					<img class="img2" alt="u2" src="img/u2.png" width="14px" height="11px">
					注册
				</a>
				</li>
		</ul>
		<%} else { %>
			<ul>
					<li>
					<a href="#">
						<img alt="" src="">
						<%= request.getSession().getAttribute("username")  %>
						</a>
				</li>
				<li>
					<a href="#">
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
					<a href="#">
						主页
					</a>
				</li>
				<li>
					<a class="text4" href="#">
							分类
						<img class="img3" alt="img3" src="img/arrow1.png" width="6px" height="8px">
					</a>
				</li>
				<li>
					<a href="#">
					全部悬赏
					</a>
				</li>
				<li>
					<a href="#">
						个人中心
					</a>
				</li>
				<li>
					<a href="#">
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
		<a class="text5" href="#">
			<img class="img4" alt="i1" src="img/i1.png" width="16px" height="14px">
			主页
		</a>
	</span>
</div>