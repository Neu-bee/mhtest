<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
</head>
<body>

<form action="/instock/list.do" method="post" id="pform">

<!-- <c:set var="list" value="${requestScope.list}"></c:set> -->
产品编号: <input type="text" name="inStock_code"   value="${inStock_code}"/>
	<br/>

<div style="text-align: right; width: 700px; margin: 20px auto;">
		<a class="btn btn-success"
			href="${pageContext.request.contextPath}/instock/instockAdd.jsp">
			增加
		</a>
	</div>
	<table class="table table-bordered table-striped table-hover table-condensed" style="width:700px;margin: 20px auto">
		<thead>
			<tr>
				<th>中转单编号</th>
				<th>中转商品id</th>
				<th>中转人id</th>
				<th>中转单号</th>
				<th>中转时间</th>
				<th>中转状态</th>
				<th>中转备注</th>
				<th>中转数量</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${requestScope.list}" var="ri">
		<tr>
		<td>${ri.inStock_id}</td>
		<td>${ri.goods_id}</td>
		<td>${ri.employee_id}</td>
		<td>${ri.inStock_code}</td>
		<td>${ri.inStock_time}</td>
		<td>${ri.inStock_status}</td>
		<td>${ri.inStock_remark}</td>
		<td>${ri.inStock_count}</td>
		<td>
		<c:if test="${ri.inStock_status eq '未确认'}">
		<a
					href="${pageContext.request.contextPath}/instock/instockDel.do?inStock_id=${ri.inStock_id}"
					class="btn btn-danger btn-xs">删除 </a> 
					<a href="${pageContext.request.contextPath}instock/instockIn.do?inStock_id=${ri.inStock_id}&goods_id=${ri.goods_id}&inStock_count=${ri.inStock_count}"
					class="btn btn-info btn-xs">确认入库</a>
		</c:if>
					<a href="${pageContext.request.contextPath}/instock/instockChange.jsp?inStock_id=${ri.inStock_id}&goods_id=${ri.goods_id}&inStock_count=${ri.inStock_count}"
					class="btn btn-success btn-xs">修改</a> 
		</td>
		</tr>
		</c:forEach>
	
		</tbody>
	</table>
</form>

 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>