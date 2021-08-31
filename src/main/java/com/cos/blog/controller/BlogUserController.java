package com.cos.blog.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//　ログインできないユーザーを/auth/**に設定
// '/'の場合、Index.jspを設定
//　'static'以下にある/js/**, /css/** など
@Controller
public class BlogUserController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "blogUser/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "blogUser/loginForm";
	}
	
	@GetMapping("/blogUser/updateForm")
	public String updateForm() {
		return "blogUser/updateForm";
	}
	
	@GetMapping("/auth/kakao/callback") 
	public @ResponseBody String kakaoCallback(String code) {

		//Postでkey=valueデータをリクエスト
		//retrofit2, okhttp, resttemplate など
		RestTemplate rt = new RestTemplate();
		
		//Header object
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//body object
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "b59f83beccbe2fa3b0046b00e13d5fce");
		params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
		params.add("code", code);
		
		//Headerとbodyを設定する
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
			new HttpEntity<>(params, header);
		
		//リクエストを行う
		ResponseEntity<String> response = rt.exchange(
				"Https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
			);
		
		return "OK!!"+response;
	}
}
