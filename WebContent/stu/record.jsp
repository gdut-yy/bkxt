<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="我的登录历史" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <c:set var="title" value="我的登录历史" />
		<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
	<script type="text/javascript" src="${webroot}/js/basic.js"></script>   
  </head>  
  <body>
   <%@ include file="../includes/header.jsp"%> 
    <div id="content">
    	<div id="left">
    		<h1>报考步骤</h1>
    		<%@ include file="../includes/stu/menu.jsp" %>
    	</div>
    	
    	<div id="right">
    		<h1>${title}</h1>
    		<%@ include file="../includes/stu/hmenu.jsp" %>
    		
    	<div class="operation">我的登录历史列表↓：</div>
			<table class="dt" border="0" cellspacing="1">
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>用户组</th>
					<th>登录时间</th>
					<th>登录IP</th>
				</tr>
				<c:forEach items="${requestScope.pm.data}" var="record" varStatus="rows">
					<tr>
						<td>${(pm.pageNo-1)*pm.pageSize+rows.count}</td>
						<td>${record.logname}</td>
						<td>${record.usergroup}</td>
						<td>${record.logtime}</td>
						<td>${record.logip}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagenav">${pm.pageNav}</div>	
    	</div>
    	<div class="clearf"></div>
    </div>
    
    <%@ include file="../includes/footer.jsp" %>
  </body>
</html>
