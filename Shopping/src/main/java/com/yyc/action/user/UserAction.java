package com.yyc.action.user;

import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.yyc.pojo.User;
import com.yyc.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService service;
	
	@RequestMapping("/user_del_sel")
	public String findByName(HttpServletRequest req,@RequestParam(value="currentpage", defaultValue="1")int currentpage,
			@RequestParam(value="pagesize", defaultValue="5")int pagesize, Map<String, PageInfo<User>> map){
		String u_name = req.getParameter("username");
		PageInfo<User> page = service.findByName(currentpage, pagesize, u_name);
		map.put("page", page);
		return "user/user-del";
	}
	
	@RequestMapping("/user_all")
	public String findAll(@RequestParam(value="currentpage", defaultValue="1")int currentpage,
			@RequestParam(value="pagesize", defaultValue="6")int pagesize, Map<String, PageInfo<User>> map){
		
		PageInfo<User> page = service.findAll(currentpage, pagesize);
		map.put("page", page);
		return "user/user-del";
	}
	
	@RequestMapping("/user_del")
	public String delById(HttpServletRequest req){
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		service.delById(u_id);
		return "user/user-del";
	}
}
