package com.cy.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
@Configuration
public class WebFilterConfig {
	@SuppressWarnings("rawtypes")
	public FilterRegistrationBean newFilterRegistrationBean() {
		//1.构建过滤器对象
		@SuppressWarnings("unused")
		FilterRegistrationBean fBean = new FilterRegistrationBean();
		//2.注册 过滤器对象
		DelegatingFilterProxy filter = new DelegatingFilterProxy("shiroFilterFactory");
		//3.进行过滤配置
		fBean.addUrlPatterns("/*");
		return fBean;
	}
}
