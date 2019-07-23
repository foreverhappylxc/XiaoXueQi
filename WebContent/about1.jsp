<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>分类查询</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/about1.css">
</head>
<body>
	<%@ include file="top.jsp"%>
	<!-- To do your work  -->
	<div class="top4" id="top4">
			<form action="SearchAbout">
				<input type="text" class="keyword" name="keyword" id="keyword" placeholder="输入查询关键字" maxlength="20">
				<select class="select1">
					<option value="*">
						全部
					</option>
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
				<select class="select2">
					<option value="*">
						全部
					</option>
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
				<div class="result">
					<div class="rLeft">
						<div class="result1">
							<h4>Title</h4>
						</div>
						<div class="result2">
							content
						</div>
						<div class="result3">
							<span>
								t_class
							</span>
							<span>
								p_btime
							</span>
							<span>
								t_campus
							</span>
							<span>
								t_rank
							</span>
						</div>
					</div>
					<div class="rRight">
						<a href="#" class="del">
							<img alt="del" src="img/del.png">
						</a>
						<a href="#" class="modify">
							<img alt="modify" src="img/modify.png">
						</a>
					</div>
				</div>
			</div>
		</div>
	<%@ include file="bottom.jsp"%>
</body>
</html>