package myJavaBean;

public class Student {
	private String id;
	private String id_card;
	private String password;
	private String name;
	private String sex;
	private String address;
	private String telephone;
	private String class_id;
	private String enrollment_time;
	private String dept_name;
	private String major;
	private String birthday;
	private String total_cred;
	public static final int PAGE = 20;
	
	public void setTotal_cred(String total_cred) {
		this.total_cred = total_cred;
	}
	
	public String getTotal_cred() {
		return total_cred;
	}
	
	public void setEnrollment_time(String enrollment_time) {
		this.enrollment_time = enrollment_time;
	}
	
	public String getEnrollment_time() {
		return enrollment_time;
	}
	
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	public String getClass_id() {
		return class_id;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	
	public String getId_card() {
		return id_card;
	}
	
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
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
}
