package com.yyc.pojo;

import java.io.Serializable;

/**  
* Title: SysUser.java 
* Description: 后台用户信息
* Copyright: Copyright (c) 2018    
* @author zhh  
* @date 2019年4月23日  
* @version 1.0  
*/
public class SysUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//编号
	private String email;//邮箱
	private String password;//密码
	private String state;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public SysUser(int id, String email, String password, String state) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.state = state;
	}
	public SysUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", email=" + email + ", password=" + password + ", state=" + state + "]";
	}

	
	
}
