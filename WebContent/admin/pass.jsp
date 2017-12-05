<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="修改密码" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
<script type="text/javascript" src="${webroot}/js/pass.js"></script>
</head>
<body>

	<%@ include file="../includes/header.jsp"%>
	<div id="content">
		<div id="left">
			<h1>管理员菜单</h1>
			<%@ include file="../includes/admin/menu.jsp"%>
		</div>

		<div id="right">
			<h1>${title}</h1>
			<%@ include file="../includes/admin/hmenu.jsp"%>

			<div class="operation">修改个人密码↓：<span class="mess" id="passModifyMess">${requestScope.passModifyMess}</span></div>
			<div class="ft">
				<form method="post" action="${webroot}/admin/pass.do">
					<table>
						<tr>
							<td class="label">旧密码：</td>
							<td colspan="2"><input type="password" name="oldpass" id="oldpass" value="${requestScope.oldpass}"/></td>
							<td class="hint">*</td>
						</tr>
						<tr>
							<td class="label">新密码：</td>
							<td colspan="2"><input type="password" name="newpass" id="newpass" value="${requestScope.newpass}"/></td>
							<td class="hint"> * 密码为英文字母、下划线或数字组合，长度为6-20位</td>
						</tr>
						<tr>
							<td class="label">确认新密码：</td>
							<td colspan="2"><input type="password" name="confirmpass" id="confirmpass" value="${requestScope.confirmpass}"/></td>
							<td class="hint"> * 两次输入的新密码要一致</td>
						</tr>
						<tr>
							<td class="label">验证码：</td>
							<td><input style="width: 65px;" type="text" name="code" id="code" /></td>
							<td><img src="${webroot}/includes/code.jsp" id="imagecode" title="点击可更换" onclick="this.src+='?tm='+ Math.random();"/></td>
							<td class="hint"> * 看不清？点击验证码图片可更换</td>
						</tr>
						<tr>
							<td colspan="4">
								<input type="submit" value="确认修改" class="button" id="submit" />
								<input type="reset" value="重 置" class="button" id="reset" />
							</td>
						</tr>
					</table>
				</form>
			</div>

		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
