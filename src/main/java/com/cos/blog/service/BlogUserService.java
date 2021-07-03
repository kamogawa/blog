package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.BlogUser;
import com.cos.blog.repository.BlogUserRepository;

//Ioc spring beanに登録してくれる。
//Service transaction 管理　＆　サービスの機能　複数Commitが行われるなどの
//repository→CRUDを持つ
@Service
public class BlogUserService {
	
	//DI
	@Autowired
	public BlogUserRepository blogUserRepository;
	
	@Transactional
	public void JoinUser(BlogUser blogUser) {
		blogUserRepository.save(blogUser);
	}
	
	@Transactional(readOnly = true) //selectする時、Transactionが走る。サービス終了時Transaction終了。（整合生を保つ）
	public BlogUser LoginUser(BlogUser blogUser) {
        return blogUserRepository.findByUsernameAndPassword(blogUser.getUsername(), blogUser.getPassword());
	}
	
}
