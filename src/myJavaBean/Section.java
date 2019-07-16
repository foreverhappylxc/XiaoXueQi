package myJavaBean;

public class Section {
	private String course_id;
	private String course_name;
	private String dept_name;
	private String credits;
	private String course_order;
	private String year;
	private String season;
	private String time;
	private String mount;
	private String room_no;
	private String time_no;
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
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setMount(String mount) {
		this.mount = mount;
	}
	
	public String getMount() {
		return mount;
	}
	
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	
	public String getRoom_no() {
		return room_no;
	}
	
	public void setTime_no(String time_no) {
		this.time_no = time_no;
	}
	
	public String getTime_no() {
		return time_no;
	}
}
