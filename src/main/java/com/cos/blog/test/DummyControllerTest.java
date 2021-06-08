package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.BlogUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.repository.BlogUserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //DI
	private BlogUserRepository blogUserRepository;
	
	@GetMapping("/dummy/users")
	public List<BlogUser> list() {
		return blogUserRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public List<BlogUser> pageList(@PageableDefault(size=1, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		List<BlogUser> users = blogUserRepository.findAll(pageable).getContent();
		return users;
	}
	
	@GetMapping("/dummy/user/{id}")
	public BlogUser detail(@PathVariable int id) {
		BlogUser user = blogUserRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("存在しないユーザーです。");
			}
		});
		return user;
		
	}
	
	@PostMapping("/dummy/join")
	public String join(BlogUser user) {
		user.setRole(RoleType.ADMIN);
		blogUserRepository.save(user);
		return "join success";
	}

}
