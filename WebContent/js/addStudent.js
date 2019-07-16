function reg(form)
{
	var str = "";
	if (form.id.value == "")
	{
		str = str + "学号 ";
	}
	if (form.id_card.value == "")
	{
		str = str + "身份证 ";
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
	if (form.address.value == "")
	{
		str = str + "住址 ";
	}
	if (form.telephone.value == "")
	{
		str = str + "电话号码 ";
	}
	if (form.class_id.value == "")
	{
		str = str + "班级号 ";
	}
	if (form.enrollment_time.value == "")
	{
		str = str + "入学时间 ";
	}
	if (form.dept_name.value == "")
	{
		str = str + "系名 ";
	}
	if (form.major.value == "")
	{
		str = str + "专业 ";
	}
	if (form.birthday.value == "")
	{
		str = str + "生日 ";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}