<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>
		<div class="form-group">
			<input value="${board.title}" type="text" id="title" class="form-control" placeholder="Enter Title" id="username">
		</div>
		<div class="form-group">
		    <textarea class="form-control" rows="5" id="content">${board.content}</textarea>
		</div>
	</form>
	<input type="hidden" id="id" value="${board.id}">
	<button id="btn-update" class="btn btn-primary">登録</button>
</div>
<script src="/js/board/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
