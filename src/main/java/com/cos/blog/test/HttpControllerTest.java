package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().password("123").email("test").username("name").build();
		System.out.println("getter:"+m.getId());
		m.setId(5000);
		System.out.println("setter:"+m.getId());
		
		return "test end";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "request get.. id :" + m.getId() + ", username: " + m.getUsername();
	}

	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "request post.. id :" + m.getId() + ", username: " + m.getUsername();	
	}
	
	@PutMapping("/http/put")
	public String putTest(Member m) {
		return "request put.. id :" + m.getId() + ", username: " + m.getUsername();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest(Member m) {
		return "request delete.. id :" + m.getId() + ", username: " + m.getUsername();
	}
}
