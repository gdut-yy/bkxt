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
	
	<%@ include file="../includes/header.jsp"%>
	<div id="content">
		<div id="left">
			<h1>管理员菜单</h1>
			<%@ include file="../includes/admin/menu.jsp"%>
		</div>

		<div id="right">
			<h1>${title}</h1>
			<%@ include file="../includes/admin/hmenu.jsp"%>
			<form action="${pageContext.request.contextPath}/jadmin/gradeinput.do" method="post" name="upload" ENCTYPE="multipart/form-data">
				<table style="margin:0 auto;">					
					<tr>
						<td style="text-align:center;"><input type="file" name="file1" id="file1" size="20" id="file1" style="border:1px solid #999;" /></td>
						<td><input class="button" type="submit" name="submit" value="点击上传" id="submit" />
					<tr/>
				</table>
			</form>
			<div class="operation">学生成绩列表↓：</div>
				<table class="dt" border="0" cellspacing="1">
				 	<c:forEach items="${pm.data}" var="supgrade" varStatus="rows">
						<tr>
							<td>${supgrade.testcardnum}</td>
							<td>${supgrade.sname}</td>
							<td>${supgrade.coursename}</td>
							<td>${supgrade.score}</td>
						</tr>
					</c:forEach>
				</table>
				<div class="pagenav">${pm.pageNav}</div>
			</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
