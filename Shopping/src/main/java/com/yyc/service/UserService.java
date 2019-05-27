package com.yyc.service;

import java.util.List;
import javax.jws.soap.SOAPBinding.Use;

import com.github.pagehelper.PageInfo;
import com.yyc.pojo.User;

public interface UserService {
	public PageInfo<User> findAll(int currentpage, int pagesize);
	public PageInfo<User> findByName(int currentpage, int pagesize,String u_name);
	public void delById(int u_id);
}
