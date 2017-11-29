<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<c:set var="title" value="报考须知" />
	<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/basic.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/basic.js"></script>
</head>

<body>
	
	<%@ include file="../includes/header.jsp"%>
	
	<div id="content">

		<div id="left">
			<h1>报考步骤</h1>
			<%@ include file="../includes/stu/menu.jsp"%>
		</div>

		<div id="right">
			<h1>${title}</h1>
			<%@ include file="../includes/stu/hmenu.jsp"%>
			<div class="operation">请您按照以下招考时间安排进行报名：↓</div>
			<div class="ft">
				<table>
					<tr><td>1、网上报名时间：2015年1月15日 08:00 - 2015年2月2日 17:00  ： 考生需要在此时间段内填写报名信息、上传电子照片、打印报名表。</td></tr>
					<tr><td>2、现场确认时间：2015年2月2日 08:00 - 2015年2月2日 17:00  ： 考生需要在此时间段内到校进行现场确认报名，需要携带材料见附件。</td></tr>
					<tr><td>3、准考证打印时间：2015年2月4日 08:00 - 考试前 ： 考生需要在此时间段内登录本系统在线打印准考证。</td></tr>
					<tr><td>4、考试时间：2015年2月6日 08:00 - 2015年2月6日 17:00 ： 考生按时参加考试。</td></tr>
					<tr><td>5、成绩与录取查询：2015年3月6日 08:00 - 2015年4月6日 17:00 ： 考生需要在此时间段内登录本系统在线查询成绩与录取信息。</td></tr>
					<tr><td>下载附件：<a href="">招生章程与报名须知</a></td></tr>
					<tr><td><input type="button" value="开始报名" class="button" onclick="location.href='${pageContext.request.contextPath}/stu/entry.do?action=notice';"/></td></tr>
				</table>
			</div>
		</div>
		
		<div class="clearf"></div>
		
	</div>

	<%@ include file="../includes/footer.jsp"%>
	
</body>
</html>
