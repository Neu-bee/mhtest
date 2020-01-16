
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆</title>
<style>
.table1 {
	font-size: x-large;
	color: yellow;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body background="images/timg.jpg">
	<br />
	<br />
	<div align="center">
		<font size="7" color="ghostwhite">购物系统登录界面</font>
	</div><br />
	<hr />
	<br /><br />
	<form id="login" action="${pageContext.request.contextPath}/login2" method="post" name="form1">
		<table align="center" class="table1">
			<tr>
				<td>用户名:</td>
				<td colspan="2"><input type="text" name="name" value="${cookie.uname.value}" id="user" />
					<font id="Mes"></font></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td colspan="2"><input type="password" name="psw" value="" id="psw" /></td>
			</tr>
			<tr>
				<td>验证码:</td>
				<td><input type="text" name="checkCode" required="required"/></td>
				<td><img alt="" src="front/checkCode.do" onclick="this.src='front/checkCode.do?t='+Math.random()"></td>
			</tr>
			<tr>
				<td>
					<p></p>
				</td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td align="right"><input type="submit" value="登录"
					id="login_btn" /></td>
				<td align="center"><input type="reset" value="重输" /></td>
			</tr>
		</table>
	</form>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<hr />

	<br />
	<table align="center" class="table1">
		<tr>
			<td>&copy;版权信息</td>
		</tr>
	</table>



</body>
</html>