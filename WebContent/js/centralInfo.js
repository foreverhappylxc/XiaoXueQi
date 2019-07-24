$(document).ready(function(){
	var s = ["江安校区", "望江校区", "华西校区"]
	function check(s2)
	{
		for (var i = 0; i < s.length; i++)
			{
			if (s2 == s[i])
				return false;
			}
		return true;
	}
	$(".button1").click(function(){
		if ($(".button1").val() == "修改")
		{
			$(".cu_pwd").removeAttr("disabled");
			$(".cu_nickname").removeAttr("disabled");
			$(".cu_age").removeAttr("disabled");
			$(".cu_email").removeAttr("disabled");
			$(".cu_campus").removeAttr("disabled");
			$(".cu_qq").removeAttr("disabled");
			$(".button1").attr({"value": "保存"});
		}
		else
		{
			var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			alert("您现在的密码是：" + $(".cu_pwd").val());
			if (check($(".cu_campus").val()))
			{
				alert("校区错误，请输入江安校区、望江校区、华西校区中的一个");
				return;
			}
			if (!reg.test($(".cu_email").val()))
			{
				alert("邮箱格式不正确");
				return;
			}
			$.ajax({
				type: "post",
				url: "CentralServlet?val=2",
				data: {
					"cu_id": $(".cu_id").val(),
					"cu_pwd": $(".cu_pwd").val(),
					"cu_nickname": $(".cu_nickname").val(),
					"cu_age": $(".cu_age").val(),
					"cu_email": $(".cu_email").val(),
					"cu_campus": $(".cu_campus").val(),
					"cu_qq": $(".cu_qq").val()
				},
				dataType: "json",
				success: function(response, status, xhr){
					if (response[0].success)
					{
						alert("修改成功");
					}
					else
					{
						alert("修改失败");
						return;
					}
				},
				error: function(status,xhr,err){
					alert("错误");
				}
			});
			$(".cu_pwd").attr({"disabled": "disabled"});
			$(".cu_nickname").attr({"disabled": "disabled"});
			$(".cu_age").attr({"disabled": "disabled"});
			$(".cu_email").attr({"disabled": "disabled"});
			$(".cu_campus").attr({"disabled": "disabled"});
			$(".cu_qq").attr({"disabled": "disabled"});
			$(".button1").attr({"value": "修改"});
		}
	});
	$(".button2").click(function(){
		window.history.back(-1); 
	});
})