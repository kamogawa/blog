<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="/blogUser/join">
		<div class="form-group">
			<label for="username">ユーザー名：</label>
			<input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="email">Email：</label>
			<input type="text" class="form-control" placeholder="Enter email" id="email">
		</div>
		<div class="form-group">
			<label for="pwd">パスワード：</label>
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">登録</button>
</div>
<script src="/blog/js/blogUser/blogUser.js"></script>
<%@ include file="../layout/footer.jsp"%>



