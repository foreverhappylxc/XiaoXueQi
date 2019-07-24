<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>分类查询</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/about1.css">
<script type="text/javascript">
$(document).ready(function(){
	$(".search").click(function(event){
		$(".result").remove();
		event.preventDefault();
		$.ajax({
			type: "post",
			url: "About1Servlet",
			data: {
				"value": "<%= request.getParameter("value")%>",
				"con": "<%= request.getParameter("con")%>",
				"str": $(".keyword").val()
			},
			dataType: "json",
			success: function(response, state, xhr){
				for (i in response)
					{
					var txt = "<div id='txt"+ i + "' class='result'><div class='rLeft'><div class='result1'><h4>"+response[i].t_title+"</h4></div><div class='result2'>" + response[i].t_content + "</div>"
						+ "<div class='result3'><span>"+ response[i].t_class +"</span><span>"+ response[i].p_btime +"</span><span>" + response[i].t_campus + "</span><span>"+ response[i].t_rank +"</span>"
						+ "</div></div><div class='rRight'><a href='#' class='del'><img alt='del' src='img/del.png'></a>";
					$(".txt").append(txt);
					}
			},
			error: function(state, xhr, error)
			{
				
			}
		});
	});
});
</script>
</head>

<body>
	<%@ include file="top.jsp"%>
	<!-- To do your work  -->
	<div class="top4" id="top4">
			<form onsubmit="return false;">
				<input type="text" class="keyword" name="keyword" id="keyword" placeholder="输入查询关键字" maxlength="20">
				<input class="search" type="button" value="搜索">
			</form>
		</div>
		<div class="content">
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
	<%@ include file="bottom.jsp"%>
</body>
</html>