package com.yyc.action.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeAction {

	@RequestMapping("tohome")
	public String toHome() {
		return "common/home";
	}
}
