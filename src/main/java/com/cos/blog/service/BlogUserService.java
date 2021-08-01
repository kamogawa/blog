package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.BlogUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.repository.BlogUserRepository;

//Ioc spring beanに登録してくれる。
//Service transaction 管理　＆　サービスの機能　複数Commitが行われるなどの
//repository→CRUDを持つ
@Service
public class BlogUserService {
	
	//DI
	@Autowired
	public BlogUserRepository blogUserRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void JoinUser(BlogUser blogUser) {
		String encPassword = encoder.encode(blogUser.getPassword());
		blogUser.setRole(RoleType.USER);
		blogUser.setPassword(encPassword);
		blogUserRepository.save(blogUser);
	}
	
//	@Transactional(readOnly = true) //selectする時、Transactionが走る。サービス終了時Transaction終了。（整合生を保つ）
//	public BlogUser LoginUser(BlogUser blogUser) {
//        return blogUserRepository.findByUsernameAndPassword(blogUser.getUsername(), blogUser.getPassword());
//	}
	
}
