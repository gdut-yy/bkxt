<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="阶段设置" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css"
	href="${webroot}/styles/basic.css" />
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

			<div class="operation">
				考生现场确认↓： <span class="mess"> <c:if
						test="${'stageSetMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>

			<div class="ft">
				<form method="post" action="${webroot}/zadmin/confirm.do">
					<table>
						<tr>
							<td class="label">输入身份证号：</td>
							<td><input class="" type="text" name="idcode">
							</td>
							<td><input class="button" type="submit" value="点击查询" />
							</td>
						</tr>
					</table>
				</form>
			</div>


			<table class="dt" border="0" cellspacing="1">
				<tr>
					<th>考生姓名</th>
					<th>考生身份证号</th>
					<th>性别</th>
					<th>是否应届生</th>
					<th>报考专业</th>
					<th>确认情况</th>
				</tr>

				<tr>
					<td>${reginfo.sname}</td>
					<td>${reginfo.idcode}</td>
					<td>${reginfo.ssex}</td>
					<td>${reginfo.isnew}</td>
					<td>${reginfo.mname}</td>
					<td>${reginfo.isconfirm}</td>
				</tr>
				<tr>
					<c:if test="${not empty reginfo.piclocation}">
						<img src="/bkxt/upload/${reginfo.piclocation}" />
					</c:if>
				</tr>

			</table>
			<div>

				<form method="post"
					action="${webroot}/zadmin/confirm.do?confirm=${reginfo.idcode}">
					<c:choose>
						<c:when test="${isconfirmed=='1'}">
												已确认
									</c:when>
						<c:when test="${isconfirmed=='0'}">
							<td><input class="button" type="submit" value="点击确定" />
							</td>
						</c:when>
					</c:choose>
				</form>

			</div>


		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
