package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.BlogUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.service.BlogUserService;

@RestController
public class BlogUserApiController {
	
	@Autowired
	private BlogUserService blogUserService;
	
	@PostMapping("/api/blogUser")
	public ResponseDto<Integer> save(@RequestBody BlogUser blogUser) {
		System.out.println("userApi");
		blogUser.setRole(RoleType.USER);
		int result =blogUserService.JoinUser(blogUser);
		return new ResponseDto<Integer>(HttpStatus.OK, result); //jacksonでjson形式でReturnされる。
	}
}
