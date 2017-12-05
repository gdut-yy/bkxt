<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="管理登录" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css"
	href="${webroot}/styles/basic.css" />
<script type="text/javascript" src="${webroot}/js/manage.js"></script>
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
			<c:choose>
				<c:when test="${applicationScope.currstage.stagename != '考号与考场分配'}">
					<table>
						<tr>
							<td>现在未开放考号与考场分配功能。</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<div class="operation">准考证号分配列表↓：</div>
					<table class="dt" border="0" cellspacing="1">
						<tr>
							<th>身份证号</th>
							<th>考生姓名</th>
							<th>报考专业</th>
							<th>准考证号</th>
						</tr>
						<c:forEach items="${pm.data}" var="reginfo" varStatus="rows">
							<tr>
								<td>${reginfo.idcode}</td>
								<td>${reginfo.sname}</td>
								<td>${reginfo.mname}</td>
								<td>${reginfo.testcardnum}</td>
							</tr>
						</c:forEach>
					</table>
					<div class="pagenav">${pm.pageNav}</div>

					<form
						action="${pageContext.request.contextPath}/jadmin/cardnum.do?action=assign"
						method="post">
						<table style="margin:0 auto;">
							<tr>
								<td><input class="button" type="submit" name="submit"
									value="确认分配" id="submit" />
							<tr />
						</table>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
