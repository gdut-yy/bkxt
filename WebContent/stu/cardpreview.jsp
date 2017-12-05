<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <c:set var="title" value="准考证打印" />
		<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/basic.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/basic.js"></script>   
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
    		
    		<input type="button" value="保存并下一步" class="button" />		
    	</div>
    	<div class="clearf"></div>
    </div>
    
    <%@ include file="../includes/footer.jsp" %>
  </body>
</html>
