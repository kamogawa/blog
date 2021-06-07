package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.BlogUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.repository.BlogUserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //DI
	private BlogUserRepository blogUserRepository;
	
	@PostMapping("/dummy/join")
	public String join(BlogUser user) {
		user.setRole(RoleType.ADMIN);
		blogUserRepository.save(user);
		return "join success";
	}

}
