package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody BlogUser blogUser) {
		System.out.println("userApi: save");

		blogUserService.JoinUser(blogUser);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/api/blogUser")
	public ResponseDto<Integer> update(@RequestBody BlogUser blogUser) {
		System.out.println("userApi: update");
		blogUserService.updateUser(blogUser);

		Authentication authentication = 
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(
								blogUser.getUsername(), blogUser.getPassword()
				));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
