package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.BlogUser;

//@Repository (省略できる。)
public interface BlogUserRepository extends JpaRepository<BlogUser, Integer> {
	// jpa naming query
	//BlogUser findByUsernameAndPassword(String username, String password);

	//@Query(value = "SELECT * FROM bloguser WHERE username = ? AND password = ?", nativeQuery = true)
	//BlogUser login(String username, String password);
	
}
