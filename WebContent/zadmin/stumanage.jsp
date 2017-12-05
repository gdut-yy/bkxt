<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="学生密码清零" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
<script type="text/javascript" src="${webroot}/js/basic.js"></script>
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

			<div class="operation">按照用户名查询学生用户↓：</div>
			<div class="ft">
				<form method="post" action="${webroot}/zadmin/stumanage.do?action=findStusLikeUsername">
					<table>
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="username" id="username"/></td>
							<td class="hint">* 结果最多显示10条记录，请尽可能准确的填写用户名！</td>
							<td><input class="button" type="submit" value="查找"/></td>
							
						</tr>
					</table>
				</form>
			</div>
			
			<div class="operation">按照身份证号查询学生用户↓：</div>
			<div class="ft">
				<form method="post" action="${webroot}/zadmin/stumanage.do?action=findStusLikeIdcode">
					<table>
						<tr>
							<td>身份证号：</td>
							<td><input type="text" name="idcode" id="idcode"/></td>
							<td class="hint">* 结果最多显示10条记录，请尽可能准确的填写身份证号！</td>
							<td><input class="button" type="submit" value="查找"/></td>
						</tr>
					</table>
				</form>
			</div>
			
			<div class="operation">查询到的用户列表↓：<span class="mess">${stuPassResetMess}</span></div>
			<table class="dt" border="0" cellspacing="1">
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>注册时间</th>
					<th>注册ip</th>
					<th>密码清零</th>
				</tr>
				<c:forEach items="${requestScope.stus}" var="stu" varStatus="rows">
					<tr>
						<td>${rows.count}</td>
						<td>${stu.username}</td>
						<td>${stu.regtime}</td>
						<td>${stu.regip}</td>
						<td><a href="${webroot}/zadmin/stumanage.do?action=stuPassReset&username=${stu.username}">清零</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
