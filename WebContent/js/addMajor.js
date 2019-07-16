function reg(form)
{
	var str = "";
	if (form.id.value == "")
	{
		str = str + "专业号 ";
	}
	if (form.name.value == "")
	{
		str = str + "专业名 ";
	}
	if (form.dept_name.value == "")
	{
		str = str + "系名 ";
	}
	if (form.manager.value == "")
	{
		str = str + "管理员名 ";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}