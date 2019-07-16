<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<link href="css/studentTop.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/top.js"></script>
<div class="div" id="div">
	<div class="div1" id="div1" onclick="show(id,1)">
		首页
		<img alt="箭头"  src="images/箭头1.png" width="20" height="20" style="position: relative; top: 5px;">
		<a href="studentHome.jsp" target="_self">
			操作介绍
		</a>
	</div>
	<div class="div2" id="div2" onclick="show(id,2)">
		信息管理
		<img alt="箭头"  src="images/箭头1.png" width="20" height="20" style="position: relative; top: 5px;">
		<a href="findGrade.jsp" target="_self">
			查看成绩
		</a>
		<a href="SInfo?id=<%= (String)request.getSession().getAttribute("id1") %>" target="_self">
			查看信息
		</a>
	</div>
	<div class="div3" id="div3" onclick="show(id,3)">
		选课管理
		<img alt="箭头"  src="images/箭头1.png" width="20" height="20" style="position: relative; top: 5px;">
		<a href="selectTakes.jsp" target="_self">
			选择课程
		</a>
		<a href="DropCourse?id=<%= (String)request.getSession().getAttribute("id1") %>&year=2014&season=春" target="_self">
			退课
		</a>
		<a href="findTakes.jsp" target="_self">
			查看课表
		</a>
	</div>
</div>
<div class="div6" id="div6">
	<div class="div7" id="div7">
	<%= (String)request.getSession().getAttribute("id1") %>
	</div>
	<div class="div8" id="div8">
	</div>
</div>
<div class="div9" id="div9" onclick="show(id,6)">
	&nbsp;
	<a href="" target="_self">
		修改密码
	</a>
	<a href="" target="_self">
		退出登录
	</a>
</div>