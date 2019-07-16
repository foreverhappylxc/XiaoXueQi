function reg(form)
{
	var str = "";
	if (form.dept_name.value == "")
	{
		str = str + "学院名 ";
	}
	if (form.building.value == "")
	{
		str = str + "学院建筑名 ";
	}
	if (form.president.value == "")
	{
		str = str + "院长名 ";
	}
	if (form.vice_president.value == "")
	{
		str = str + "副院长名 ";
	}
	if (form.description.value == "")
	{
		str = str + "描述 ";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}