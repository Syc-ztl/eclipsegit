package com.sun.chenglixin.config;

import java.util.ArrayList;
/**
 * 拦截器的配置类
 */
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sun.chenglixin.interceptor.LoginInterceptor;
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer{
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor loginInterceptor=new LoginInterceptor();
		
		InterceptorRegistration ir=registry.addInterceptor(loginInterceptor);
		// 黑名单
		ir.addPathPatterns("/**");
		
		// 不拦 注册/登录 静态资源
		List<String> patterns=new ArrayList<String>();
		// 静态资源
		patterns.add("/css/**");
		patterns.add("/images/**");
		patterns.add("/js/**");
		// 注册和登录页面
		patterns.add("/index.html");
		patterns.add("/login.html");
		patterns.add("/register.html");
		patterns.add("/business_registe.html");
		patterns.add("/forget_password.html");
		// 注册和登录控制器
		patterns.add("/user/login");
		patterns.add("/user/add_user");
		patterns.add("/user/send");
		
		patterns.add("/company/login");
		patterns.add("/company/add_company");
		patterns.add("/company/send_company");
		
		// 白名单
		ir.excludePathPatterns(patterns);
	
	}
}
