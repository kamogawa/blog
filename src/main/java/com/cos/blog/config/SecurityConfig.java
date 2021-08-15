package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;

//bean 登録：SpringContainerでObjectを管理する。
@Configuration //ioc
@EnableWebSecurity //security filter追加
@EnableGlobalMethodSecurity(prePostEnabled = true) //特定アドレスにアクセスすると認証を先に行う。
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean//ioc
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	//security時パスワードがどんなハッシュを使ったか設定
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // csrfトークン非活性
		    .authorizeRequests()
		        .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
		        .permitAll()
		        .anyRequest()
		        .authenticated()
		    .and()
		    	.formLogin()
		    	.loginPage("/auth/loginForm")
		    	.loginProcessingUrl("/auth/loginProc") //該当パスはspring bootがログインを行う
		    	.defaultSuccessUrl("/");
	}
}
