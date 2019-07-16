package myJavaBean;

public class Department {
	private String dept_name;
	private String building;
	private String president;
	private String vice_president;
	private String description;
	public static final int PAGE = 20;
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	
	public void setBuilding(String building) {
		this.building = building;
	}
	
	public String getBuilding() {
		return building;
	}
	
	public void setPresident(String president) {
		this.president = president;
	}
	
	public String getPresident() {
		return president;
	}
	
	public void setVice_president(String vice_president) {
		this.vice_president = vice_president;
	}
	
	public String getVice_president() {
		return vice_president;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
