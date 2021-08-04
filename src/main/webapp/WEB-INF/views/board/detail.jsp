<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<button class="btn btn-secondray" onclick="history.back()">前へ戻る</button>
	<button id="btn-update" class="btn btn-warning">修正</button>
	<button id="btn-delete" class="btn btn-danger">削除</button>
	<br><br>
	<div class="form-group">
		<h3>${board.title}</h3>
	</div>
	<hr/>
	<div class="form-group">
		<div>${board.content}</div>
	</div>
	<hr/>
</div>
<script src="/js/board/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
