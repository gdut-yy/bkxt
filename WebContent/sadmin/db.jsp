<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="数据库管理" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
<script type="text/javascript" src="${webroot}/js/sadminmanage.js"></script>
</head>
<body>
	
	<%
		session.setAttribute("group", 1);
	%>


	<%@ include file="../includes/header.jsp"%>
	<div id="content">
		<div id="left">
			<h1>管理员菜单</h1>
			<%@ include file="../includes/admin/menu.jsp"%>
		</div>

		<div id="right">
			<h1>数据库管理</h1>
			<%@ include file="../includes/admin/hmenu.jsp"%>

			<div class="operation">数据库备份↓：
				<span class="mess">
					<c:if test="${'backupMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>	
			</div>

			<div class="ft">
				<form method="post" action="${webroot}/sadmin/db.do?action=backup" enctype="multipart/form-data">
					<table>
						<tr>
							<td><input class="button" type="submit" value="开始备份"/></td>
						</tr>	
					</table>
				</form>
			</div>
			
			<div class="operation">数据库恢复↓：
				<span class="mess">
					<c:if test="${'restoreMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>	
			</div>
			<div class="ft">
				<form method="post" action="${webroot}/sadmin/db.do?action=restore" enctype="multipart/form-data">
					<table>
						<tr>
							<td><input type="file" name="file2"><td>
							<td><input class="button" type="submit" value="确认恢复"/></td>
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
