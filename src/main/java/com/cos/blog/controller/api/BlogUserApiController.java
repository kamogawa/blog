package com.cos.blog.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.BlogUser;

@RestController
public class BlogUserApiController {

	@PostMapping("/api/blogUser")
	public ResponseDto<Integer> save(@RequestBody BlogUser blogUser) {
		System.out.println("userApi");
		return new ResponseDto<Integer>(200, 1);
	}
}
