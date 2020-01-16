<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet" />
</head>
<body>
<c:if test="${sessionScope.uname==null}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
	<p>
		欢迎您，尊敬的管理员[${sessionScope.uname}]先生
		<a class="btn btn-success"
		href="${pageContext.request.contextPath}/exit.do"> 安全退出 </a>
	</p>
	<!-- 当前在线人数为： ${online} 人 -->
	
		
		
	<div class="container-fluid">
		<div class="row" style="background-color: ghostwhite">
			<div class="col-md-12" style="height: 100px">
				<h1 align="center">仓储管理系统</h1>

			</div>

		</div>
		<div class="row" style="height: 400px">
			<div class="col-md-3">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne"> 系统管理 </a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<ul>
									<li><a href="#">用户管理</a></li>
									<li><a href="${pageContext.request.contextPath}/changePsw.jsp"
										target="goodsFrame">修改密码</a></li>
									<li><a href="#">权限管理</a></li>
								</ul>
							</div>
						</div>
					</div>


					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"> 基础数据管理 </a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse in">
							<div class="panel-body">
								<ul>
									<li><a class="btn btn-success btn-xs" id="pt_but">商品类型管理</a></li>
									<li><a class="btn btn-success btn-xs" id="p_but">供应商管理</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-toggle="collapse"
									data-parent="#accordion" href="#collapseThree"> 仓库管理 </a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse in">
							<div class="panel-body">
								<ul>
									<li><a href="${pageContext.request.contextPath}/product/list.do"
										target="goodsFrame">库存表单</a></li>
									<li><a href="${pageContext.request.contextPath}/instock/list.do"
										target="goodsFrame">入库操作</a></li>
									<li><a href="${pageContext.request.contextPath}/outstock/list.do"
										target="goodsFrame">出库操作</a></li>
									<li><a href="${pageContext.request.contextPath}/goods/list.do"
										target="goodsFrame">商品列表</a></li>
									<li><a href="${pageContext.request.contextPath}/goods/cart.jsp"
										target="goodsFrame">我的购物车</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="col-md-9" style="height: 500px" id="right">
				<iframe name="goodsFrame" width="100%" height="100%"></iframe>
			</div>

		</div>

	</div>
	<div class="row">
			<div class="col-md-12"
				style="text-align: center; height: 50px; line-height: 50px; background-color: ghostwhite">

				&copy;版权信息。。。。。。。</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
		$("#p_but").click(function() {
			$.ajax({
				cache : false,
				url : "productor/productor.html",
				
				method : "post",
				async : true,
				error : function() {
					alert("error");
				},
				success : function(data) {
					$("#right").html(data);
				}
			});
			return false;
		})
		
		
		
		$("#pt_but").click(function() {
			$.ajax({
				cache : false,
				url : "productType/productType.html",
				method : "post",
				async : true,
				error : function() {
					alert("error");
				},
				success : function(data) {
					$("#right").html(data);
				}
			});
			return false;
		})
		
		
		
		
		
		
		
	</script>
	
	
</body>
</html>