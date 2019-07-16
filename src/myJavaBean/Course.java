package myJavaBean;

public class Course {
	private String course_id;
	private String course_name;
	private String dept_name;
	private String credits;
	public static final int PAGE = 20;
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
	public String getCourse_id() {
		return course_id;
	}
	
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public String getCourse_name() {
		return course_name;
	}
	
	public void setCredits(String credits) {
		this.credits = credits;
	}
	
	public String getCredits() {
		return credits;
	}
}
