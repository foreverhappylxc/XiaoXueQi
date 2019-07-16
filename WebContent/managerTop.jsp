<%@page import="myJavaBean.Find"%>
<%@page import="myJavaBean.ID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<link href="css/managerTop.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/top.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<div class="div" id="div">
	<div class="div1" id="div1" onclick="show(id,1)">
		首页
		<img alt="箭头"  src="images/箭头.png" width="30" height="30" style="position: relative; top: 10px;">
		<a href="managerHome.jsp" target="_self">
			操作介绍
		</a>
	</div>
	<div class="div2" id="div2" onclick="show(id,2)">
		课程管理
		<img alt="箭头"  src="images/箭头.png" width="30" height="30" style="position: relative; top: 10px;">
		<a href="FindDepartment?val=4" target="_self">
			添加课程
		</a>
		<a href="findCourse.jsp" target="_self">
			查看课程
		</a>
		<a href="findSection.jsp" target="_self">
			查看节
		</a>
	</div>
	<div class="div3" id="div3" onclick="show(id,3)">
		学生管理
		<img alt="箭头"  src="images/箭头.png" width="30" height="30" style="position: relative; top: 10px;">
		<a href="FindDepartment?val=1" target="_self">
			添加学生
		</a>
		<a href="findStudent.jsp" target="_self">
			查看信息
		</a>
	</div>
	<div class="div4" id="div4" onclick="show(id,4)">
		老师管理
		<img alt="箭头"  src="images/箭头.png" width="30" height="30" style="position: relative; top: 10px;">
		<a href="FindDepartment?val=3" target="_self">
			添加老师
		</a>
		<a href="findTeacher.jsp" target="_self">
			查看信息
		</a>
	</div>
	<div class="div5" id="div5" onclick="show(id,5)">
		学院管理
		<img alt="箭头"  src="images/箭头.png" width="30" height="30" style="position: relative; top: 10px;">
		<a href="addDepartment.jsp" target="_self">
			添加学院
		</a>
		<a href="Department?page=1" target="_self">
			查看信息
		</a>
	</div>
	<div class="di" id="di" onclick="show(id,6)">
		专业管理
		<img alt="箭头"  src="images/箭头.png" width="30" height="30" style="position: relative; top: 10px;">
		<a href="FindDepartment?val=2" target="_self">
			添加专业
		</a>
		<a href="findMajor.jsp" target="_self">
			查看信息
		</a>
	</div>
</div>
<div class="div6" id="div6">
	<div class="div7" id="div7">
	<%= (String)request.getSession().getAttribute("id") %>
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
