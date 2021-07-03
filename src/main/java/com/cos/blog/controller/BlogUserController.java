package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogUserController {
	
	@GetMapping("/blogUser/joinForm")
	public String joinForm() {
		return "blogUser/joinForm";
	}
	
	@GetMapping("/blogUser/loginForm")
	public String loginForm() {
		return "blogUser/loginForm";
	}
}
