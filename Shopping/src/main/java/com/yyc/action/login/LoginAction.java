package com.yyc.action.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyc.pojo.SysUser;
import com.yyc.service.LoginService;

@Controller
@RequestMapping("/syslogin")
public class LoginAction {
	@Autowired
	private LoginService service;

	@RequestMapping("loginjsp")
	public String toLogin() {
		return "login/login";
	}

	@RequestMapping("/dologin")
	public String dologin(SysUser user, Map<String, String> map, HttpServletRequest req) {

		Subject currentUser = SecurityUtils.getSubject();
		// String email = req.getParameter("email");
		System.out.println(user);
		System.out.println(user.getState());
		String state = service.findStateByEmail(user.getEmail());

		// isAuthenticated()判断是否登录过
		if (!currentUser.isAuthenticated()) {// 未登录
			UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());// 存储用户名和密码的对象
			token.setRememberMe(true);
			if (state.equals("1")){
				try {
					currentUser.login(token);// 进行登录
				} catch (AuthenticationException ae) {
					// unexpected condition? error?
					// 登录失败
					map.put("error", "账号或密码错误，请重新输入");
					return "login/login";
				}
			}else {
				map.put("error", "您的账号已被封禁！");
				return "login/login";
			}
		}

		Session session = currentUser.getSession();
		session.setAttribute("loginuser", user.getEmail());
		/*
		 * String email = req.getParameter("email"); String password =
		 * req.getParameter("password"); service.findByNameAndPwd(email,
		 * password); System.out.println(service.findByNameAndPwd(email,
		 * password));
		 * 
		 * if (service.findByNameAndPwd(email, password)==null) {
		 * map.put("error", "账号或密码错误，请重新输入"); return "login/login"; }
		 */

		return "common/index";
	}
}
