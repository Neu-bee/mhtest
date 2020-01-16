<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<form class="form-horizontal" role="form"
		style="width: 550px; margin: 10px auto;"
		action="${pageContext.request.contextPath}/goods/goodsSave.do"
		method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="type_id" class="col-sm-3 control-label">类型id:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="type_id"
					placeholder="请输入类型id" name="type_id">
			</div>
		</div>
		<div class="form-group">
			<label for="supplier_id" class="col-sm-3 control-label">供应商id:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="supplier_id"
					placeholder="请输供应商id" name="supplier_id">
			</div>
		</div>

		<div class="form-group">
			<label for="goods_code" class="col-sm-3 control-label">商品号码:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="goods_code"
					placeholder="请输入商品号码" name="goods_code">
			</div>
		</div>
		<div class="form-group">
			<label for="goods_name" class="col-sm-3 control-label">商品名称:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="goods_name"
					placeholder="请输入商品名称" name="goods_name">
			</div>
		</div>
		<div class="form-group">
			<label for="goods_count" class="col-sm-3 control-label">商品数量:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="goods_count"
					placeholder="请输入商品数量" name="goods_count">
			</div>
		</div>
		<div class="form-group">
			<label for="goods_price" class="col-sm-3 control-label">价格:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="goods_price"
					placeholder="请输入价格" name="goods_price">
			</div>
		</div>
		<div class="form-group">
			<label for="goods_img" class="col-sm-3 control-label">图片:</label>
			<div class="col-sm-9">
			<input type="file"  name="goods_img">
			</div>
		</div>
		<div class="form-group">
			<label for="goods_mes" class="col-sm-3 control-label">备注:</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="goods_mes"
					placeholder="商品备注" name="goods_mes">
			</div>
		</div>
		

		<div class="form-group">
			<label for="inputEmail3" class="col-sm-3 control-label"></label>
			<div class="col-sm-9">
				<input type="submit" class="btn btn-info col-sm-12" value="保存" />
			</div>
		</div>
	</form>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>