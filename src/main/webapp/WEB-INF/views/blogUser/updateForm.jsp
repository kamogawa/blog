<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>
		<input type="hidden" id="id" value="${principal.blogUser.id}">
		<div class="form-group">
			<label for="username">ユーザー名：</label>
			<input type="text" value="${principal.blogUser.username}" class="form-control" placeholder="Enter username" id="username" readonly>
		</div>
		<div class="form-group">
			<label for="email">Email：</label>
			<input type="text" value="${principal.blogUser.email}" class="form-control" placeholder="Enter email" id="email">
		</div>
		<div class="form-group">
			<label for="pwd">パスワード：</label>
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button id="btn-update" class="btn btn-primary">修正登録</button>
	</form>
</div>
<script src="/js/blogUser/blogUser.js"></script>
<%@ include file="../layout/footer.jsp"%>



