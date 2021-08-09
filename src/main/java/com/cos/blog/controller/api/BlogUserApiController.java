package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.BlogUser;
import com.cos.blog.service.BlogUserService;

@RestController
public class BlogUserApiController {
	
	@Autowired
	private BlogUserService blogUserService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody BlogUser blogUser) {
		System.out.println("userApi: save");

		blogUserService.JoinUser(blogUser);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //jacksonでjson形式でReturnされる。
	}
	
	@PutMapping("/blogUser")
	public ResponseDto<Integer> update(@RequestBody BlogUser blogUser) {
		System.out.println("userApi: update");
		
		blogUserService.updateUser(blogUser);
		System.out.println(blogUser.getEmail());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
//	@PostMapping("/api/blogUser/login")
//	public ResponseDto<Integer> login(@RequestBody BlogUser blogUser) {
//		System.out.println("userApi: login");
//		blogUser.setRole(RoleType.USER);
//		BlogUser principal = blogUserService.LoginUser(blogUser);
//		System.out.println(principal);
//
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
	
	
	
}
