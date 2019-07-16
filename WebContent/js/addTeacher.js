function reg(form)
{
	var str = "";
	if (form.id.value == "")
	{
		str = str + "老师号 ";
	}
	if (form.password.value == "")
	{
		str = str + "密码 ";
	}
	if (form.name.value == "")
	{
		str = str + "姓名 ";
	}
	if (form.sex.value == "")
	{
		str = str + "性别 ";
	}
	if (form.major.value == "")
	{
		str = str + "专业 ";
	}
	if (form.dept_name.value == "")
	{
		str = str + "系名 ";
	}
	if (form.e_mail.value == "")
	{
		str = str + "邮箱 ";
	}
	if (form.telephone.value == "")
	{
		str = str + "电话号码 ";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}