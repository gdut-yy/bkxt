<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<c:set var="title" value="系统状态" />
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/basic.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/basic.js"></script>
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

			<div class="operation">当前系统状态信息↓：</div>
			<div class="ft">
				<table>
					<tr>
						<td>1、系统当前处于 
							<span style="color:#DE5B25;"> ${ applicationScope.currstage.stagename } </span>阶段
						</td>
					</tr>
					<tr>
						<td>2、当前在线人数共 
							<span style="color:#DE5B25;"> ${ applicationScope.count } </span> 人
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="clearf"></div>
		
	</div>

	<%@ include file="../includes/footer.jsp"%>
	
</body>
</html>