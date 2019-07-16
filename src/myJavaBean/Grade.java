package myJavaBean;

public class Grade {
	private String id;
	private String name;
	private String course_id;
	private String course_name;
	private String dept_name;
	private String credits;
	private String course_order;
	private String year;
	private String season;
	private String grade;

	public static final int PAGE = 20;
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
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
	
	public void setCourse_order(String course_order) {
		this.course_order = course_order;
	}
	
	public String getCourse_order() {
		return course_order;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
