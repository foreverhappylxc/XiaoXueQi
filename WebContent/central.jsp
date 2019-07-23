<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人中心</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/central.css">
<script type="text/javascript" src="js/central.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<div class="content">
		<div class="left">
			<div>
				基本信息
			</div>
			<ul class="item0">
				<li>
					<a class="item00" href="#"> 
						账户 
						<img class="arrow2" alt="arrow2" src="img/arrow3.png">
					</a>
					<ul class="item">
						<li class="subitem">
							<a href="#">
								个人信息
							</a>
						</li>
						<li class="subitem">
							<a href="#">
								实名认证
							</a>
						</li>
						<li class="subitem">
							<a href="#">
								审核中心
							</a>
						</li>
					</ul>
				</li>
			</ul>
			<div>
				任务记录
			</div>
			<ul class="item0">
				<li>
					<a class="item01" href="#"> 
						我发布的任务
						<img class="arrow21" alt="arrow2" src="img/arrow3.png">
					 </a>
					<ul class="item1">
						<li class="subitem1">
							<a href="#">
								等待进行
							</a>
						</li>
						<li class="subitem1">
							<a href="#">
								进行中
							</a>
						</li>
						<li class="subitem1">
							<a href="#">
								已完成
							</a>
						</li>
						<li class="subitem1">
							<a href="#">
								未完成
							</a>
						</li>
						<li class="subitem1">
							<a href="#">
								已删除
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="item02" href="#"> 
						我接受的任务
						<img class="arrow22" alt="arrow2" src="img/arrow3.png">
					 </a>
					<ul class="item2">
						<li class="subitem2">
							<a href="#">
								进行中
							</a>
						</li>
						<li class="subitem2">
							<a href="#">
								已完成
							</a>
						</li>
						<li class="subitem2">
							<a href="#">
								未完成
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="item03" href="#"> 
						我审核的任务
						<img class="arrow23" alt="arrow2" src="img/arrow3.png">
					 </a>
					<ul class="item3">
						<li class="subitem3">
							<a href="#">
								通过
							</a>
						</li>
						<li class="subitem3">
							<a href="#">
								未通过
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
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
				
			</div>
		</div>
	</div>
	<%@ include file="bottom.jsp" %>
</body>
</html>