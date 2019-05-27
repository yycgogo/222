package com.yyc.service.im;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyc.dao.user.UserDao;
import com.yyc.pojo.User;
import com.yyc.service.UserService;
@Service
public class UserServiceIm implements UserService{
	@Autowired
	private UserDao User;
	@Override
	public PageInfo<User> findByName(int currentpage, int pagesize,String u_name) {
		PageHelper.startPage(currentpage,pagesize);
		List<User> list = User.findByName(u_name);
		PageInfo<User> page = new PageInfo<>(list);
		return page;
	}
	@Override
	public PageInfo<User> findAll(int currentpage, int pagesize) {
		PageHelper.startPage(currentpage,pagesize);
		List<User> list = User.findAll();
		PageInfo<User> page = new PageInfo<>(list);
		return page;
	}
	@Override
	public void delById(int u_id) {
		User.delById(u_id);
	}

}
