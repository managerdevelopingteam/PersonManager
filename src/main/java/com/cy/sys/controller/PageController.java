package com.cy.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter1";
	}
	@RequestMapping("doPageUI")
	public String doPageUI(){
		//Thread.sleep(2000);
		return "common/page";
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI(){
			return "login";
	}
	@RequestMapping("sys/{page}")
	public String doModuleUI(//rest
			@PathVariable String page) {
		return "sys/"+page;
	}
}
