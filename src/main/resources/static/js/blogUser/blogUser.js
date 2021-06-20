let index = {
	init: function() {
		$("#btn-save").on("click",() => {
			this.saveUser();
		});
	},
	saveUser: function() {
		let data = {
				username: $("#username").val(),
				email: $("#email").val(),
				password: $("#password").val()
		};
		//Joinリクエスト
		$.ajax({
			type: "POST",
			url: "/blog/api/blogUser",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"//レスポンスタイプ設定　defaultがjson
		}).done(function(response){
			alert("登録完了");
			location.href="/blog";
		}).fail(function(error){
			alert(error);
		});
		
	}
}

index.init();