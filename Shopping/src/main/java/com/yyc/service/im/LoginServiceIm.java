package com.yyc.service.im;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyc.dao.SysUserDao;
import com.yyc.pojo.SysUser;
import com.yyc.service.LoginService;

@Service
public class LoginServiceIm implements LoginService{
	@Autowired
	private SysUserDao user;

	@Override
	public String findStateByEmail(String email) {
		return user.findStateByEmail(email);
	}

	@Override
	public List<SysUser> findByNameAndPwd(String email, String password) {
		user.findByNameAndPwd(email, password);
		return null;
	}
	
}
