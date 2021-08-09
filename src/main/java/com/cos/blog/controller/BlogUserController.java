package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//　ログインできないユーザーを/auth/**に設定
// '/'の場合、Index.jspを設定
//　'static'以下にある/js/**, /css/** など
@Controller
public class BlogUserController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "blogUser/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "blogUser/loginForm";
	}
	
	@GetMapping("/blogUser/updateForm")
	public String updateForm() {
		return "blogUser/updateForm";
	}
}
