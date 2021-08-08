package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.BlogUser;

//@Repository (省略できる。)
public interface BlogUserRepository extends JpaRepository<BlogUser, Integer> {
	//SELECT * FROM bloguser WHERE username = 1?;
	Optional<BlogUser> findByUsername(String username);
	
	// jpa naming query
	//BlogUser findByUsernameAndPassword(String username, String password);

	//@Query(value = "SELECT * FROM bloguser WHERE username = ? AND password = ?", nativeQuery = true)
	//BlogUser login(String username, String password);
	
}
