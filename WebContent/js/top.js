$(document).ready(function(){
	$(".text2").mouseover(function(){
		$(".img1").attr("src", "img/u11.png");
    });
	$(".text2").mouseout(function(){
		$(".img1").attr("src", "img/u1.png");
	});
	$(".text3").mouseover(function(){
		$(".img2").attr("src", "img/u21.png");
    });
	$(".text3").mouseout(function(){
		$(".img2").attr("src", "img/u2.png");
	});
	$(".text4").mouseover(function(){
		$(".img3").attr("src", "img/arrow11.png");
    });
	$(".text4").mouseout(function(){
		$(".img3").attr("src", "img/arrow1.png");
	});
	$(".text5").mouseover(function(){
		$(".img4").attr("src", "img/i11.png");
    });
	$(".text5").mouseout(function(){
		$(".img4").attr("src", "img/i1.png");
	});
	var aa;
	var bb;
	$(".text4").click(function(){
		$(".type").css({"display": "inline-block"});
		$(".type").css({"position": "absolute","top": $(".top2").offset().top + $(".top2").height(), "left": $(".text4").offset().left});
		clearInterval(bb);
		i = $(".type").height();
		aa = setInterval(function(){
			if (i >= 240)
			{
				$(".type div").css({"visibility": "visible"});
				clearInterval(aa);
				return;
			}
			i+=2;
			$(".type").css({"width": 2 * i, "height": i});
		}, 3);
	});
	$(document).click(function(e){
		if ($(e.target).attr("class") != "type" && $(e.target).attr("class") != "text4")
		{
			$(".type div").css({"visibility": "hidden"});
			clearInterval(aa);
			j = $(".type").height();
			bb = setInterval(function(){
				if (j <= 0) 
				{
					$(".type").css({"display": "none"});
					clearInterval(bb);
					return;
				}
				j-=2;
				$(".type").css({"width": 2 * j, "height": j});
			}, 3);
		}
	});
})