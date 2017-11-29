<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<div id="hmenu">
	<ul>
		<li><a href="${webroot}/admin/logout.do">退出系统</a></li>
		<li><a href="${webroot}/admin/pass.jsp">修改密码</a></li>
		<li><a href="${webroot}/admin/record.do">我的登录历史</a></li>
		<li>欢迎您：${sessionScope.adminuser.adminname }</li>
	</ul>
</div>