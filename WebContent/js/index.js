$(document).ready(function(){
	var df;
	isLeft = true;
	i1 = 0;
	j1 = 0;
	var scroll = function()
		{
		if (isLeft)
			{
				i1++;
				$(".m42").animate({scrollLeft: 280 * i1},800);
				j1++;
				if (j1 == 2)
				{
					isLeft = false;
				}
			}
			else
			{
				i1--;
				$(".m42").animate({scrollLeft: 280 * i1},800)
				j1--;
				if (j1 == 0)
				{
					isLeft = true;
				}
			}
		}
	jQuery(function($){
		df = setInterval(scroll,1000);
	});
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
	var cc;
	var dd;
	$(".m3d11").mouseover(function(){
		clearInterval(dd);
		i = $(".m3d11").css("opacity");
		cc = setInterval(function(){
			if (i <= 0)
			{
				$(".m3d11").css({"opacity": 0});
				clearInterval(cc);
				return;
			}
			i -= 0.005;
			$(".m3d11").css({"opacity": i});
		}, 1);
	});
	$(".m3d11").mouseout(function(){
		clearInterval(cc);
		j = $(".m3d11").css("opacity");
		dd = setInterval(function(){
			if (j >= 1)
			{
				$(".m3d11").css({"opacity": 1});
				clearInterval(dd);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m3d11").css({"opacity": j});
		}, 1);
	});
	var ee;
	var ff;
	$(".m3d12").mouseover(function(){
		clearInterval(ff);
		i = $(".m3d12").css("opacity");
		ee = setInterval(function(){
			if (i <= 0)
			{
				$(".m3d12").css({"opacity": 0});
				clearInterval(ee);
				return;
			}
			i -= 0.005;
			$(".m3d12").css({"opacity": i});
		}, 1);
	});
	$(".m3d12").mouseout(function(){
		clearInterval(ee);
		j = $(".m3d12").css("opacity");
		ff = setInterval(function(){
			if (j >= 1)
			{
				$(".m3d12").css({"opacity": 1});
				clearInterval(ff);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m3d12").css({"opacity": j});
		}, 1);
	});
	var gg;
	var hh;
	$(".m3d13").mouseover(function(){
		clearInterval(hh);
		i = $(".m3d13").css("opacity");
		gg = setInterval(function(){
			if (i <= 0)
			{
				$(".m3d13").css({"opacity": 0});
				clearInterval(gg);
				return;
			}
			i -= 0.005;
			$(".m3d13").css({"opacity": i});
		}, 1);
	});
	$(".m3d13").mouseout(function(){
		clearInterval(gg);
		j = $(".m3d13").css("opacity");
		hh = setInterval(function(){
			if (j >= 1)
			{
				$(".m3d13").css({"opacity": 1});
				clearInterval(hh);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m3d13").css({"opacity": j});
		}, 1);
	});
	var ii;
	var jj;
	$(".m3d14").mouseover(function(){
		clearInterval(jj);
		i = $(".m3d14").css("opacity");
		ii = setInterval(function(){
			if (i <= 0)
			{
				$(".m3d14").css({"opacity": 0});
				clearInterval(ii);
				return;
			}
			i -= 0.005;
			$(".m3d14").css({"opacity": i});
		}, 1);
	});
	$(".m3d14").mouseout(function(){
		clearInterval(ii);
		j = $(".m3d14").css("opacity");
		jj = setInterval(function(){
			if (j >= 1)
			{
				$(".m3d14").css({"opacity": 1});
				clearInterval(jj);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m3d14").css({"opacity": j});
		}, 1);
	});
	$(".middle4").mouseover(function(){
		$(".m41").css({"background-color": "#09c4dc"});
	});
	$(".middle4").mouseout(function(){
		$(".m41").css({"background-color": "#fd463e"});
	});
	var a1;
	var b1;
	$(".m4211").mouseout(function(){
		df = setInterval(scroll, 1000);
		clearInterval(b1);
		i = $(".m4211").css("opacity");
		a1 = setInterval(function(){
			if (i <= 0)
			{
				$(".m4211").css({"opacity": 0});
				clearInterval(a1);
				return;
			}
			i -= 0.005;
			$(".m4211").css({"opacity": i});
		}, 1);
	});
	$(".m4211").mouseover(function(){
		clearInterval(df);
		clearInterval(a1);
		j = $(".m4211").css("opacity");
		b1 = setInterval(function(){
			if (j >= 1)
			{
				$(".m4211").css({"opacity": 1});
				clearInterval(b1);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m4211").css({"opacity": j});
		}, 1);
	});
	var a2;
	var b2;
	$(".m4221").mouseout(function(){
		df = setInterval(scroll, 1000);
		clearInterval(b2);
		i = $(".m4221").css("opacity");
		a2 = setInterval(function(){
			if (i <= 0)
			{
				$(".m4221").css({"opacity": 0});
				clearInterval(a2);
				return;
			}
			i -= 0.005;
			$(".m4221").css({"opacity": i});
		}, 1);
	});
	$(".m4221").mouseover(function(){
		clearInterval(df);
		clearInterval(a2);
		j = $(".m4221").css("opacity");
		b2 = setInterval(function(){
			if (j >= 1)
			{
				$(".m4221").css({"opacity": 1});
				clearInterval(b2);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m4221").css({"opacity": j});
		}, 1);
	});
	var a3;
	var b3;
	$(".m4231").mouseout(function(){
		df = setInterval(scroll, 1000);
		clearInterval(b3);
		i = $(".m4231").css("opacity");
		a3 = setInterval(function(){
			if (i <= 0)
			{
				$(".m4231").css({"opacity": 0});
				clearInterval(a3);
				return;
			}
			i -= 0.005;
			$(".m4231").css({"opacity": i});
		}, 1);
	});
	$(".m4231").mouseover(function(){
		clearInterval(df);
		clearInterval(a3);
		j = $(".m4231").css("opacity");
		b3 = setInterval(function(){
			if (j >= 1)
			{
				$(".m4231").css({"opacity": 1});
				clearInterval(b3);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m4231").css({"opacity": j});
		}, 1);
	});
	var a4;
	var b4;
	$(".m4241").mouseout(function(){
		df = setInterval(scroll, 1000);
		clearInterval(b4);
		i = $(".m4241").css("opacity");
		a4 = setInterval(function(){
			if (i <= 0)
			{
				$(".m4241").css({"opacity": 0});
				clearInterval(a4);
				return;
			}
			i -= 0.005;
			$(".m4241").css({"opacity": i});
		}, 1);
	});
	$(".m4241").mouseover(function(){
		clearInterval(df);
		clearInterval(a4);
		j = $(".m4241").css("opacity");
		b4 = setInterval(function(){
			if (j >= 1)
			{
				$(".m4241").css({"opacity": 1});
				clearInterval(b4);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m4241").css({"opacity": j});
		}, 1);
	});
	var a5;
	var b5;
	$(".m4251").mouseout(function(){
		df = setInterval(scroll, 1000);
		clearInterval(b5);
		i = $(".m4251").css("opacity");
		a5 = setInterval(function(){
			if (i <= 0)
			{
				$(".m4251").css({"opacity": 0});
				clearInterval(a5);
				return;
			}
			i -= 0.005;
			$(".m4251").css({"opacity": i});
		}, 1);
	});
	$(".m4251").mouseover(function(){
		clearInterval(df);
		clearInterval(a5);
		j = $(".m4251").css("opacity");
		b5 = setInterval(function(){
			if (j >= 1)
			{
				$(".m4251").css({"opacity": 1});
				clearInterval(b5);
				return;
			}
			j = Number(j) + Number(0.005);
			$(".m4251").css({"opacity": j});
		}, 1);
	});
})