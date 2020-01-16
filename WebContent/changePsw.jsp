<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<form class="form-horizontal" role="form" id="changeForm"
		style="width: 550px; margin: 10px auto;"
		action="${pageContext.request.contextPath}/changePsw.do"
		method="post">
		
		<input type="hidden" id="employee_id" name="employee_id" value="${employee_id}"> 
				<div class="form-group">
			<label  class="col-sm-3 control-label">原密码:</label>
			<div class="col-sm-9">
				<input type="password" class="form-control" required="required" name="userOldPwd">
			</div>
			<div class="clo-md-3" id="showPwd"></div>
		</div>
		</div>
		
		
		
		<div class="form-group">
			<label class="col-sm-3 control-label">请输入新密码:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" required="required" name="userNewPwd">
			</div>
		</div>


		<div class="form-group">
			<label class="col-sm-3 control-label">请再次输入新密码:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" required="required" name="userNewPwd1">
			</div>
		</div>
		

		<div class="form-group">
			<label class="col-sm-3 control-label"></label>
			<div class="col-sm-9">
				<input type="submit" class="btn btn-info btn-block" value="保存" />
			</div>
		</div>
	</form>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
var flag=false;
$("[name=userOldPwd]").change(function(){
	
	$.ajax({
	    cache: false,
	    type: "post",
	    url:"checkPwd.do",
	    data:{"oldPwd":$("[name=userOldPwd]").val()},
	    async: false,
	    error: function(request) {
	        alert("Connection error");
	    },
	    success: function(data) {
	    	if(data=="true"){
	    		tag=true;
	    		$("#showPwd").html("输入正确");
	    	}
	    	else{
	    		tag=false;
	    		$("#showPwd").html("原密码不正确");
	    	}
	    }
	});
});

$(":submit").click(function(){
	if(tag==false){
		alert("原密码不正确");
		return false;
	}
	if($("[name=userNewPwd]").val()!=$("[name=userNewPwd1]").val()){
		alert("密码和确认密码不一致");
		tag=false;
		return false;
	}
	if(tag=true){
		$.ajax({
		    cache: false,
		    type: "POST",
		    data:$("#changeForm").serialize(),
		    url:"changePsw.do",
		    async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
		    	ocation.href =data;
		    }
		});
	}
});

</script>

</body>
</html>