
<%@page import="java.util.Map"%>
<
<%@page import="java.util.List"%>
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

<form action="${pageContext.request.contextPath}/goods/list.do" method="post" name="form1">
 <div style="width: 700px;margin: 20px auto;">


<c:set var="querMap" value="${requestScope.queryMap}"></c:set>

	产品编号: <input type="text" name="goods_code"   value="${queryMap.goods_code}"/>
	产品名称: <input type="text" name="goods_name"   value="${queryMap.goods_name}"/>
	<input type="submit" value="查询" class="btn btn-info"/>
</div>
<div style="text-align: right; width: 700px; margin: 20px auto;">
		<a class="btn btn-success"
			href="${pageContext.request.contextPath}/goods/goodsAdd.jsp">
			增加
		</a>
	</div>
	<table class="table table-bordered table-striped table-hover table-condensed" style="width:800px;margin: 20px auto">
		<thead>
			<tr>
				<th>商品id</th>
				<th>类型id</th>
				<th>供应商id</th>
				<th>商品号码</th>
				<th>商品名称</th>
				<th>商品数量</th>
				<th>价格</th>
				<th>图片</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${requestScope.pb.data}" var="rs">
		
		<tr>
				<td>${rs.goods_id}</td>
				<td>${rs.type_id}</td>
				<td>${rs.supplier_id}</td>
				<td>${rs.goods_code}</td>
				<td>${rs.goods_name}</td>
				<td>${rs.goods_count}</td>
				<td>${rs.goods_price}</td>
				<td>${rs.goods_img}</td>
				<td>${rs.goods_mes}</td>
				<td>
					<a href="${pageContext.request.contextPath}/goods/goodsDel.do?goods_id=${rs.goods_id}"
					class="btn btn-danger btn-xs">删除 </a> 
					
					<a class="btn btn-success btn-xs"
					href="${pageContext.request.contextPath}/goods/goodsChange.jsp?goods_id=${rs.goods_id}">修改</a> 
					
				</td>
		
		</c:forEach>
		
		
			<tr>
			<td colspan="11">
			<a href="javascript:goPage(1)">首页</a>
			<a href="javascript:goPage(${requestScope.pb.currentPage-1})">上一页</a>
			
			
		<c:forEach   begin="1" end="${requestScope.pb.pages}" var="pg">
			<c:choose>
				<c:when test="${requestScope.pb.currentPage==pg}">
				${pg}
				</c:when>
				<c:otherwise>
				<a href="javascript:goPage(${pg})">${pg}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
			<a href="javascript:goPage(${requestScope.pb.currentPage+1})">下一页</a>
			<a href="javascript:goPage(${requestScope.pb.pages})">尾页</a>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			 <select name="pageSize" onchange="goPage(1)">
          	      	<option value="1">1</option>
          	      	<option value="2">2</option>
          	      	<option value="3">3</option>
          	 </select>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			共${requestScope.pb.pages}页，共${requestScope.pb.totalCount}条
          	  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          	  当前页是第 ${requestScope.pb.currentPage} 页
			</td>
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="cutPage" value="1" />
</form> 
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
function goPage(cutPageParam){
	form1.cutPage.value=cutPageParam;
	form1.submit();
} 
$("[name=pageSize] option[value=${requestScope.pb.pageSize}]").attr("selected","selected");
</script>
</body>
</html>