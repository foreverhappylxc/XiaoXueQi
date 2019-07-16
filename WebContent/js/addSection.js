function reg(form)
{
	var str = "";
	if (form.ci.value == "")
	{
		str = str + "课程号 ";
	}
	if (form.cn.value == "")
	{
		str = str + "课程名 ";
	}
	if (form.dn.value == "")
	{
		str = str + "系名 ";
	}
	if (form.c.value == "")
	{
		str = str + "学分 ";
	}
	if (form.course_order.value == "")
	{
		str = str + "课序号 ";
	}
	if (form.year.value == "")
	{
		str = str + "年份 ";
	}
	if (form.season.value == "")
	{
		str = str + "学期 ";
	}
	if (form.time.value == "")
	{
		str = str + "课节数 ";
	}
	if (form.mount.value == "")
	{
		str = str + "课容量 ";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}