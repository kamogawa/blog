let index = {
	init: function() {
		$("#btn-save").on("click",() => {
			this.saveBoard();
		});		
		$("#btn-delete").on("click",() => {
			this.deletebyId();
		});
		$("#btn-update").on("click",() => {
			this.updatebyId();
		});
	},
	deletebyId: function() {
		let id = $("#id").text();
		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id,
			dataType: "json"
		}).done(function(response){
			alert("削除完了");
			location.href="/";
		}).fail(function(error){
			alert(error);
		});
	},
	saveBoard: function() {
		let data = {
				title: $("#title").val(),
				content: $("#content").val(),
		};
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(response){
			alert("登録完了");
			location.href="/";
		}).fail(function(error){
			alert(error);
		});
	},
	updatebyId: function() {
		let id = $("#id").val();
		console.log(id);

		let data = {
				title: $("#title").val(),
				content: $("#content").val(),
		};
		$.ajax({
			type: "PUT",
			url: "/api/board/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(response){
			alert("修正完了");
			location.href="/";
		}).fail(function(error){
			alert(error);
		});
	}
}

index.init();