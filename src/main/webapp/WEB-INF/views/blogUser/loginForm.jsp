<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">ユーザー名：</label>
			<input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="pwd">パスワード：</label>
			<input type="password"
			class="form-control" name="password" placeholder="Enter password" id="password">
		</div>
		<button id="btn-login" class="btn btn-primary">登録</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=b59f83beccbe2fa3b0046b00e13d5fce&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height="38px" src="/image/kakao_login_button.png" src=""></a>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>



