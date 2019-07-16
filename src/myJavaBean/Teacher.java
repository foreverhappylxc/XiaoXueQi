package myJavaBean;

public class Teacher {
	private String id;
	private String password;
	private String name;
	private String sex;
	private String dept_name;
	private String major;
	private String e_mail;
	private String telephone;
	public static final int PAGE = 20;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	public String getE_mail() {
		return e_mail;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
}
