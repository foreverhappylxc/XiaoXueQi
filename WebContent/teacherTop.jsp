<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<link href="css/teacherTop.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/top.js"></script>
<div class="div" id="div">
	<div class="div1" id="div1" onclick="show(id,1)">
		首页
		<img alt="箭头"  src="images/箭头2.png" width="16" height="34" style="position: relative; top: 10px;">
		<a href="teacherHome.jsp" target="_self">
			操作介绍
		</a>
	</div>
	<div class="div2" id="div2" onclick="show(id,2)">
		教学管理
		<img alt="箭头"  src="images/箭头2.png" width="16" height="34" style="position: relative; top: 10px;">
		<a href="findTeaches.jsp" target="_self">
			查看课表
		</a>
	</div>
	<div class="div3" id="div3" onclick="show(id,3)">
		老师管理
		<img alt="箭头"  src="images/箭头2.png" width="16" height="34" style="position: relative; top: 10px;">
		<a href="SelectCourse?id=<%= (String)request.getSession().getAttribute("id2") %>&page=1" target="_self">
			选择授课
		</a>
		<a href="modifyGrade.jsp" target="_self">
			查看信息
		</a>
	</div>
</div>
<div class="div6" id="div6">
	<div class="div7" id="div7">
	<%= (String)request.getSession().getAttribute("id2") %>
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
