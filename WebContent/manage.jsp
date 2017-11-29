<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="管理登录" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
<script type="text/javascript" src="${webroot}/js/manage.js"></script>
</head>

<body>
	<%@ include file="./includes/header.jsp"%>
	<div id="content">
		<div id="left">
			<h1>系统使用说明</h1>
			<div class="ft" style="border: none;">
				<table>
					<tr><td>1、本系统各类管理员通过本页面登录！</td></tr>
					<tr><td>2、管理员账号均由系统管理员添加！</td></tr>
					<tr><td>3、忘记用户名和密码请联系系统管理员！</td></tr>
				</table>
			</div>
		</div>

		<div id="right">
			<h1>${title}</h1>
			<div class="operation">验证登录信息↓：<span class="mess" id="adminLoginMess">${requestScope.adminLoginMess}</span></div>
			<div class="ft">
				<form method="post" action="${webroot}/adminLogin.do">
					<table>
						<tr>
							<td class="label">管理员：</td>
							<td colspan="2"><input type="text" name="adminname" id="adminname" value="${requestScope.adminname}"/></td>
							<td class="hint">*</td>
						</tr>
						<tr>
							<td class="label">密码：</td>
							<td colspan="2"><input type="password" name="adminpass" id="adminpass" value="${requestScope.adminpass}" /></td>
							<td class="hint">*</td>
						</tr>
						<tr>
							<td class="label">验证码：</td>
							<td><input style="width: 65px;" type="text" name="code" id="code" value="${requestScope.code}" /></td>
							<td><img src="${webroot}/includes/code.jsp" id="imagecode" title="点击可更换" onclick="this.src+='?tm='+ Math.random();"/></td>
							<td class="hint">*</td>
						</tr>
						<tr>
							<td colspan="4">
								<input type="submit" value="登 录 系 统" class="button" id="submit" />
								<input type="reset" value="重 置" class="button" id="reset" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div class="clearf"></div>

	</div>

	<%@ include file="./includes/footer.jsp"%>
</body>
</html>
