var num = [0,0,0,0,0,0,0];

function show(x,i)
{
	if (num[i-1] == "0")
		{
		var element = document.getElementById(x);
		var c = element.children;
		for (j = 1; j < c.length; j++)
			{
				c[j].style = "display: block;";
			}
		num[i-1]++;
		}
	else 
		{
		var element = document.getElementById(x);
		var c = element.children;
		for (j = 1; j < c.length; j++)
			{
				c[j].style = "display: none;";
			}
		num[i-1]--;
		}
}