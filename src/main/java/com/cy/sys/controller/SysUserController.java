package com.cy.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.sys.pojo.JsonResult;

@RestController
@RequestMapping("/user/")
public class SysUserController {
	@RequestMapping("doLogin")
	public JsonResult doLogin(String username,String password) {
		//获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		//通过Subject对象提交用户信息,交给shiro框架进行认证操作
		//对用户进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		//对用户信息进行身份验证
		subject.login(token);
		//分析:
		//1)token会传给shiro的SecurityManager
		//2)SecurityManager将token传递给认证管理器
		//3)认证管理器会将token传递给realm
		return new JsonResult("login ok");
	}
}
