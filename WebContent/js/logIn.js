function reg(form)
{
	var str = "";
	if (form.userName.value == "")
	{
		str = str + "用户名 ";
	}
	if (form.password.value == "")
	{
		str = str + "密码";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}