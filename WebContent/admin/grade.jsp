<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>考生报名</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/basic.css">
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
			<h1>成绩信息</h1>
			<%@ include file="../includes/admin/hmenu.jsp"%>

			<div class="operation">按条件查询成绩信息↓：</div>
			<div class="ft">
				水电工放水电费
			</div>



		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
