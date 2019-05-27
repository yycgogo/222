package com.yyc.dao.user;

import java.util.List;

import com.yyc.pojo.SysUser;
import com.yyc.pojo.User;

public interface UserDao {
	
	public List<User> findAll();
	public List<User> findByName(String u_name);
	public void delById(int u_id);
}
