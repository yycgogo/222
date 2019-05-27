package com.yyc.pojo;

public class User {

	private int u_id;
	private String u_telephone;
	private String u_email;
	private String u_name;
	private String u_photo;
	private String u_birthday;
	
	public User() {
		super();
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_telephone() {
		return u_telephone;
	}
	public void setU_telephone(String u_telephone) {
		this.u_telephone = u_telephone;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_photo() {
		return u_photo;
	}
	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}
	public String getU_birthday() {
		return u_birthday;
	}
	public void setU_birthday(String u_birthday) {
		this.u_birthday = u_birthday;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_telephone=" + u_telephone + ", u_email=" + u_email + ", u_name=" + u_name
				+ ", u_photo=" + u_photo + ", u_birthday=" + u_birthday + "]";
	}
	
}
