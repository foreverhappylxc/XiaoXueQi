package entity;

import java.sql.Date;

public class Notice {
	private String ad_id;
	private int n_id;
	private String n_title;
	private String n_content;
	private int n_amount;
	private Date r_time;
	
	public String getAd_id() {
		return ad_id;
	}
	
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	
	public int getN_id() {
		return n_id;
	}
	
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	
	public String getN_title() {
		return n_title;
	}
	
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	
	public String getN_content() {
		return n_content;
	}
	
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	
	public int getN_amount() {
		return n_amount;
	}
	
	public void setN_amount(int n_amount) {
		this.n_amount = n_amount;
	}
	
	public Date getR_time() {
		return r_time;
	}
	
	public void setR_time(Date r_time) {
		this.r_time = r_time;
	}
}
