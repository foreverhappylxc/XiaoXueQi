$(document).ready(function(){
	$(".item00").click(function(event)
	{
		event.preventDefault();
		if ($(".item").css("display") == "none")
		{
			$(".item").css({"display": "block"});
			$(".item1").css({"display": "none"});
			$(".item2").css({"display": "none"});
			$(".item3").css({"display": "none"});
			$(".arrow2").attr("src","img/arrow2.png");
			$(".arrow21").attr("src","img/arrow3.png");
			$(".arrow22").attr("src","img/arrow3.png");
			$(".arrow23").attr("src","img/arrow3.png");
		}
		else
		{
			$(".item").css({"display": "none"});
			$(".arrow2").attr("src","img/arrow3.png");
		}
	});
	$(".item01").click(function(event)
	{
		event.preventDefault();
		if ($(".item1").css("display") == "none")
		{
			$(".item1").css({"display": "block"});
			$(".item").css({"display": "none"});
			$(".item2").css({"display": "none"});
			$(".item3").css({"display": "none"});
			$(".arrow21").attr("src","img/arrow2.png");
			$(".arrow2").attr("src","img/arrow3.png");
			$(".arrow22").attr("src","img/arrow3.png");
			$(".arrow23").attr("src","img/arrow3.png");
		}
		else
		{
			$(".item1").css({"display": "none"});
			$(".arrow21").attr("src","img/arrow3.png");
		}
	});
	$(".item02").click(function(event)
	{
		event.preventDefault();
		if ($(".item2").css("display") == "none")
		{
			$(".item2").css({"display": "block"});
			$(".item1").css({"display": "none"});
			$(".item").css({"display": "none"});
			$(".item3").css({"display": "none"});
			$(".arrow22").attr("src","img/arrow2.png");
			$(".arrow2").attr("src","img/arrow3.png");
			$(".arrow21").attr("src","img/arrow3.png");
			$(".arrow23").attr("src","img/arrow3.png");
		}
		else
		{
			$(".item2").css({"display": "none"});
			$(".arrow22").attr("src","img/arrow3.png");
		}
	});
	$(".item03").click(function(event)
	{
		event.preventDefault();
		if ($(".item3").css("display") == "none")
		{
			$(".item3").css({"display": "block"});
			$(".item1").css({"display": "none"});
			$(".item2").css({"display": "none"});
			$(".item").css({"display": "none"});
			$(".arrow23").attr("src","img/arrow2.png");
			$(".arrow2").attr("src","img/arrow3.png");
			$(".arrow21").attr("src","img/arrow3.png");
			$(".arrow22").attr("src","img/arrow3.png");
		}
		else
		{
			$(".item3").css({"display": "none"});
			$(".arrow23").attr("src","img/arrow3.png");
		}
	});
});