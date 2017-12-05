<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="entity.Reginfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<c:set var="title" value="准考证打印" />
	<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/basic.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/printview.css" />
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
			<c:choose>
				<c:when test="${applicationScope.currstage.stagename != '准考证打印与考试'}">
					<table>
						<tr><td>1、现在未开放打印准考证功能。</td></tr>
						<tr><td>2、请考生于2015年1月19日-考试前自行打印专业课考试准考证。</td></tr>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr><td>1、现在已开放打印准考证功能。</td></tr>
						<tr><td>2、请考生于2015年1月19日-考试前自行打印专业课考试准考证。</td></tr>
					<div id="testcard">
						<h2>
							2016年天津理工大学中环信息学院专升本考试
						</h2>
						<h3>
							准 考 证
						</h3>
						<div id="left">
							<p>
								<p><span class="label">姓　　名：</span>${reginfo.sname}</p>
								<p><span class="label">性　　别：</span>${reginfo.ssex}</p>
								<p><span class="label">身份证号：</span>${reginfo.idcode}</p>
								<p><span class="label">报考专业：</span>${reginfo.mname}</p>
								<p><span class="label">准考证号：</span>${reginfo.testcardnum}</p>
								<p><span class="label">考点名称：</span>${applicationScope.school.shname}</p>
							</p>
							<p><span class="label">考点地址：</span>${applicationScope.school.shaddr}</p>
							<p><span class="label">考场地点：</span><%=((Reginfo)request.getAttribute("reginfo")).getExamroom().split("-")[1]%></p>
							<p><span class="label">考 场 号：</span><%=((Reginfo)request.getAttribute("reginfo")).getExamroom().split("-")[0]%></p>
							<p><span class="label">座 位 号：</span>${reginfo.seatnum}</p>
							<p><span class="label">考试时间：</span>
								<c:forEach items="${courses}" var="course">
								${course.cname}:${fn:substring(course.cstarttime,0,16)}-${fn:substring(course.cendtime,11,16)}</p><p><span class="label"></span>
								</c:forEach>
							</p>
						</div>
						<div id="right">
							<img width="91px" height="112px" src="../upload/${reginfo.username}.jpg" />
						</div>
						<hr />
						<div id="bottom">
							<p><b>考生须知：</b></p>
							<p>	1、考生须凭准考证和身份证或公安户籍部门开具的贴有近期免冠照片的身份证号码证明、护照等证件参加考试。</p>
							<p>	2、考生必须按规定时间（09:00）入场，考试开始（09:30）后，禁止入场。</p>
							<p> 3、考生只准携带必要的文具入场，如铅笔、黑色签字笔、橡皮。禁止携带任何书籍、笔记、资料、报刊、草稿纸以及各种无线通信工具、录放音机、电子记事本等物品。</p>
							<p>	4、考生答题前应在指定位置认真填写试卷中的姓名、准考证号等栏目；必须严格按照要求做答题目，书写部分一律使用黑色字迹签字笔，否则按违规处理。</p>
							<p>	5、在考试结束（11:30）前禁止提前退场。考场内必须严格遵守考场纪律，对于违反考场规定和不服从考试工作人员管理者，取消考试成绩并按相关规定处理。</p>
							<p>	6、考试铃声响时，要立即停止答题，待监考员允许后方可离开考场。离开时不准携带试卷、草稿纸离场。</p>
						</div>
					</div>
					</table>
				</c:otherwise>
			</c:choose>

				
			
			
			
			</div>

		</div>
		
		<div class="clearf"></div>
		
	</div>

	<%@ include file="../includes/footer.jsp"%>
	
</body>
</html>
