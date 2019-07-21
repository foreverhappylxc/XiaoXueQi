package entity;

import java.sql.Date;

public class Comment {
	private int co_id;
	private int t_id;
	private String cu_id;
	private String co_content;
	private Date a_btime;
	private int a_pamount;
	private int a_samount;
	
	public int getCo_id() {
		return co_id;
	}
	
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
	
	public int getT_id() {
		return t_id;
	}
	
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	
	public String getCu_id() {
		return cu_id;
	}
	
	public void setCu_id(String cu_id) {
		this.cu_id = cu_id;
	}
	
	public String getCo_content() {
		return co_content;
	}
	
	public void setCo_content(String co_content) {
		this.co_content = co_content;
	}
	
	public Date getA_btime() {
		return a_btime;
	}
	
	public void setA_btime(Date a_btime) {
		this.a_btime = a_btime;
	}
	
	public int getA_pamount() {
		return a_pamount;
	}
	
	public void setA_pamount(int a_pamount) {
		this.a_pamount = a_pamount;
	}
	
	public int getA_samount() {
		return a_samount;
	}
	
	public void setA_samount(int a_samount) {
		this.a_samount = a_samount;
	}
}
