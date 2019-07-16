function reg(form)
{
	var str = "";
	if (form.email.value == "")
	{
		str = str + "用户ID ";
	}
	if (form.scode.value == "")
	{
		str = str + "验证码 ";
	}
	if (form.npwd.value == "")
	{
		str = str + "新密码";
	}
	if (str != "")
	{
		str = str + "不能为空";
		alert(str);
		return false;
	}
}