function reg1(form)
{
	var str = "";
	if (form.course_id.value == "")
	{
		str = str + "课程号 ";
	}
	if (form.course_name.value == "")
	{
		str = str + "课程名 ";
	}
	if (form.dept_name.value == "")
	{
		str = str + "系名 ";
	}
	if (form.credits.value == "")
	{
		str = str + "学分 ";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}