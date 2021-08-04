let index = {
	init: function() {
		$("#btn-save").on("click",() => {
			this.saveBoard();
		});		
		$("#btn-delete").on("click",() => {
			this.deletebyId();
		});
	},
	deletebyId: function() {
		var id = $("#id").text();
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
}

index.init();