package entity;

public class Customer {
	private String cu_id;
	private String cu_pwd;
	private String cu_name;
	private String cu_nickname;
	private int cu_age;
	private String cu_sex;
	private String cu_email;
	private int cu_credit;
	private String cu_campus;
	private String cu_authority;
	private String cu_img;
	private int cu_qq;
	
	public Customer() {};
	public Customer(String cu_id,String cu_pwd) {
		this.cu_id=cu_id;
		this.cu_pwd=cu_pwd;
	};
	
	public  String getCu_id() {
		return cu_id;
	}
	
	public void setCu_id(String cu_id) {
		this.cu_id = cu_id;
	}
	
	public String getCu_pwd() {
		return cu_pwd;
	}
	
	public void setCu_pwd(String cu_pwd) {
		this.cu_pwd = cu_pwd;
	}
	
	public String getCu_name() {
		return cu_name;
	}
	
	public void setCu_name(String cu_name) {
		this.cu_name = cu_name;
	}
	
	public String getCu_nickname() {
		return cu_nickname;
	}
	
	public void setCu_nickname(String cu_nickname) {
		this.cu_nickname = cu_nickname;
	}
	
	public int getCu_age() {
		return cu_age;
	}
	
	public void setCu_age(int cu_age) {
		this.cu_age = cu_age;
	}
	
	public String getCu_sex() {
		return cu_sex;
	}
	
	public void setCu_sex(String cu_sex) {
		this.cu_sex = cu_sex;
	}
	
	public String getCu_email() {
		return cu_email;
	}
	
	public void setCu_email(String cu_email) {
		this.cu_email = cu_email;
	}
	
	public int getCu_credit() {
		return cu_credit;
	}
	
	public void setCu_credit(int cu_credit) {
		this.cu_credit = cu_credit;
	}
	
	public String getCu_campus() {
		return cu_campus;
	}
	
	public void setCu_campus(String cu_campus) {
		this.cu_campus = cu_campus;
	}
	
	public String getCu_authority() {
		return cu_authority;
	}
	
	public void setCu_authority(String cu_authority) {
		this.cu_authority = cu_authority;
	}
	
	public String getCu_img() {
		return cu_img;
	}
	
	public void setCu_img(String cu_img) {
		this.cu_img = cu_img;
	}
	
	public int getCu_qq() {
		return cu_qq;
	}
	
	public void setCu_qq(int cu_qq) {
		this.cu_qq = cu_qq;
	}
}
