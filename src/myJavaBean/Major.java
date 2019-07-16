package myJavaBean;

public class Major {
	private String id;
	private String name;
	private String dept_name;
	private String manager;

	public static final int PAGE = 20;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public String getManager() {
		return manager;
	}
}
