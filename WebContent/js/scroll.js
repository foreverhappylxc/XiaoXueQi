jQuery(function($){
		var df;
		isLeft = true;
		i = 0;
		j = 0;
		df = setInterval(function(){
			if (isLeft)
			{
				i++;
				$(".m42").animate({scrollLeft: 280 * i},500);
				j++;
				if (j == 2)
				{
					isLeft = false;
				}
			}
			else
			{
				i--;
				$(".m42").animate({scrollLeft: 280 * i},500)
				j--;
				if (j == 0)
				{
					isLeft = true;
				}
			}
		},1000);
	});