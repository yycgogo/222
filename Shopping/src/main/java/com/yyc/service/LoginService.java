package com.yyc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.yyc.pojo.SysUser;

public interface LoginService {
	public String findStateByEmail(@Param("email")String email);
	public List<SysUser> findByNameAndPwd(@Param("email")String email,
			@Param("password")String password);
}
