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
					<div class="operation">考场分配↓：</div>
					<form
						action="${pageContext.request.contextPath}/jadmin/room.do?action=assign"
						method="post">
						<table style="margin:0 auto;">
							<tr>
								<td>单考场人数：</td>
								<td><input type="text" name="perRoom" /></td>
								<td><input class="button" type="submit" name="submit"
									value="分配考场" id="submit" /></td>
							<tr />
						</table>
					</form>
					<form
						action="${pageContext.request.contextPath}/jadmin/room.do?action=assure"
						method="post">
						<table class="dt" border="0" cellspacing="1">
							<tr>
								<th>考场号</th>
								<th>考场人数</th>
								<th>分配教室</th>
							</tr>
							<c:if test="${room>0}">
								<c:forEach var="rom" begin="1" end="${room-1}">
									<tr>
										<td>${rom}</td>
										<td>${perroom}</td>
										<td><input type="text" name="rooms" /></td>
									</tr>
								</c:forEach>
								<tr>
									<td>${room}</td>
									<td>${remain}</td>
									<td><input type="text" name="rooms" /></td>
								</tr>
							</c:if>
						</table>
						<div>
							<input class="button" type="submit" name="submit" value="确认分配"
								id="submit" />
						</div>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
