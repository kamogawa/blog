package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//bean 登録：SpringContainerでObjectを管理する。
@Configuration //ioc
@EnableWebSecurity //security filter追加
@EnableGlobalMethodSecurity(prePostEnabled = true) //特定アドレスにアクセスすると認証を先に行う。
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .authorizeRequests()
		        .antMatchers("/auth/**")
		        .permitAll()
		        .anyRequest()
		        .authenticated()
		    .and()
		    	.formLogin()
		    	.loginPage("/auth/loginForm");
	}
}
