package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.BlogUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.repository.BlogUserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //DI
	private BlogUserRepository blogUserRepository;

	@DeleteMapping("/dummy/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			blogUserRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "削除失敗しました。";
		}
		
		return "削除成功しました。";
	}
	
	@Transactional //関数の実行が終わる時自動的にCommitされる。
	@PutMapping("/dummy/user/{id}")
	public BlogUser updateUser(@PathVariable int id, @RequestBody BlogUser requestUser) {
		BlogUser user = blogUserRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("更新に失敗しました。");
		});
		user.setEmail(requestUser.getEmail());
		user.setPassword(requestUser.getPassword());
		
		return null;
	}
	
	@GetMapping("/dummy/users")
	public List<BlogUser> list() {
		return blogUserRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public List<BlogUser> pageList(@PageableDefault(size=1, sort="id", direction=Sort.Direction.DESC) Pageable pageable) {
		Page<BlogUser> pageUsers = blogUserRepository.findAll(pageable);
		List<BlogUser> users = pageUsers.getContent();
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
