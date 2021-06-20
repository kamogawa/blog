package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public int JoinUser(BlogUser blogUser) {
		try {
			blogUserRepository.save(blogUser);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ユーザー登録失敗：" + e.getMessage());
		}
		return -1;
	}
}
