package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.BlogUser;
import com.cos.blog.repository.BlogUserRepository;

@Service //Beanに登録
public class PrincipalDetailService implements UserDetailsService {
	@Autowired
	private BlogUserRepository blogUserRepository;

	//springがログインを実施する時、username, passwordを取得する
	//password 部分は自動でやってくる
	//usernameはDBにあるか確認を行う必要がある為、処理を実装する。
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		BlogUser principal = blogUserRepository.findByUsername(username)
				.orElseThrow(()-> {
					return new UsernameNotFoundException("ユーザーが見つかりませんでした。：" + username);
				});
		
		return new PrincipalDetail(principal); // securityのセッションにユーザー情報が登録される。
	}
	
}
