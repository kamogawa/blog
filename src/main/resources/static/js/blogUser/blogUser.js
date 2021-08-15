let index = {
	init: function() {
		$("#btn-save").on("click",() => {
			console.log("xx");
			this.saveUser();
		});
		$("#btn-update").on("click",() => {
			this.updateUser();
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
			url: "/auth/joinProc",
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
	updateUser: function() {
		let data = {
				id: $("#id").val(),
				username: $("#username").val(),
				email: $("#email").val(),
				password: $("#password").val()
		};
		//Joinリクエスト
		console.log(data);
		$.ajax({
			type: "PUT",
			url: "/api/blogUser",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"//レスポンスタイプ設定　defaultがjson
		}).done(function(response){
			console.log(response);
			alert("登録完了");
			location.href="/";
		}).fail(function(error){
			alert(error);
		});
	},
}

index.init();