$(function() {
	//判断是否已经登录
	$.ajax({
		type : "POST",
		url : baseUrl + "/user/admin/checklogin",
		contentType : "application/json",
		dataType : "json",
		data:JSON.stringify({"userType":2}),
		async : false,
		success : function(jsonResult) {
			if(jsonResult.code==403){
				window.location.href = baseUrl+"/admin/pages/login.html";
			}
		},
		error : function() {
			alert("系统错误");
		}
	});
});

