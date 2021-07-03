package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.BlogUser;

//@Repository (省略できる。)
public interface BlogUserRepository extends JpaRepository<BlogUser, Integer> {
	// JPA naming query
	BlogUser findByUsernameAndPassword(String username, String password);
	
}
