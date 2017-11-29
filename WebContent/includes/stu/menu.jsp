<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<div id="menu">
	<a href="${webroot}/stu/notice.do">报考须知</a>
	<a href="${webroot}/stu/entry.do">我的报名信息</a>
	<a href="${webroot}/stu/photo.jsp">上传照片</a>
	<a href="${webroot}/stu/form.do">报名表打印</a>
	<a href="${webroot}/stu/card.do">准考证打印</a>	
	<a href="${webroot}/stu/grade.do">成绩与录取查询</a>
	<a href="${webroot}/stu/record.do">我的登录历史</a>
	<a href="${webroot}/stu/pass.jsp">修改密码</a>
	<a href="${webroot}/stu/logout.do">退出系统</a>
</div>