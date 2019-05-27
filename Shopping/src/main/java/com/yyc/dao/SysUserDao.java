package com.yyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyc.pojo.SysUser;

/**  
* Title: SysUserDao.java 
* Description: 
* Copyright: Copyright (c) 2018    
* @author zhh  
* @date 2019年4月23日  
* @version 1.0  
*/
public interface SysUserDao {
	
	public SysUser findByNameAndPwd(@Param("email")String email,
			@Param("password")String password);
	
	public String findStateByEmail(@Param("email")String email);
}
