package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.BlogUser;

import lombok.Data;
import lombok.Getter;

// spring security がログインリクエストを持っていく。
// ログインが完了されたらUserDetailsタイプのObjectを
// spring securityの独自のセッションに保存する。
@Data
public class PrincipalDetail implements UserDetails{

	private BlogUser blogUser; //コンポジション composition

	public PrincipalDetail(BlogUser bloguser) {
		this.blogUser = bloguser;
	}
	
	@Override
	public String getPassword() {
		return blogUser.getPassword();
	}

	@Override
	public String getUsername() {
		return blogUser.getUsername();
	}
	//アカウントが切れてないことを確認する。（true:切れてない）
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//アカウントがロックされてないことを確認する。（true:ロックされてない）
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//パスワードが切れてないことを確認する。（true:切てない）
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//アカウントが利用可能か確認する。（true:Enable）
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//アカウントが持つ権限を返す。
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collerctors = new ArrayList<>();
		collerctors.add(()->{return "ROLE_"+blogUser.getRole();});
		return collerctors;
	}
}
