package entity;

import java.util.Date;

public class Task {
	private int t_id;
	private String cu_id;
	private String t_title;
	private String t_content;
	private int t_amount;
	private String t_state;
	private int t_num;
	private String t_class;
	private Date p_btime;
	private Date p_etime;
	private int t_money;
	private String t_campus;
	private String t_rank;
	
	public Task()
	{
		//to do this
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
	
	public String getT_title() {
		return t_title;
	}
	
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	
	public String getT_content() {
		return t_content;
	}
	
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	
	public int getT_amount() {
		return t_amount;
	}
	
	public void setT_amount(int t_amount) {
		this.t_amount = t_amount;
	}
	
	public String getT_state() {
		return t_state;
	}
	
	public void setT_state(String t_state) {
		this.t_state = t_state;
	}
	
	public int getT_num() {
		return t_num;
	}
	
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	
	public String getT_class() {
		return t_class;
	}
	
	public void setT_class(String t_class) {
		this.t_class = t_class;
	}
	
	public Date getP_btime() {
		return p_btime;
	}
	
	public void setP_btime(Date p_btime) {
		this.p_btime = p_btime;
	}
	
	public Date getP_etime() {
		return p_etime;
	}
	
	public void setP_etime(Date p_etime) {
		this.p_etime = p_etime;
	}
	
	public int getT_money() {
		return t_money;
	}
	
	public void setT_money(int t_money) {
		this.t_money = t_money;
	}
	
	public String getT_campus() {
		return t_campus;
	}
	
	public void setT_campus(String t_campus) {
		this.t_campus = t_campus;
	}
	
	public String getT_rank() {
		return t_rank;
	}
	
	public void setT_rank(String t_rank) {
		this.t_rank = t_rank;
	}
}
