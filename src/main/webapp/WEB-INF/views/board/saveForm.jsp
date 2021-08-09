<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>
		<div class="form-group">
			<label for="title">タイトル</label>
			<input type="text" id="title" class="form-control" placeholder="Enter Title" id="username">
		</div>
		<div class="form-group">
		    <label for="content">内容:</label>
		    <textarea class="form-control" rows="5" id="content"></textarea>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">登録</button>
</div>
<script src="/js/board/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
