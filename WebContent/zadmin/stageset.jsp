<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="阶段设置" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
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

			<div class="operation">设置当前阶段↓：
				<span class="mess">
					<c:if test="${'stageSetMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			
			<div class="ft">
				<form method="post" action="${webroot}/zadmin/stageset.do?action=stageSet">
					<table>
						<tr>
							<td class="label">选择阶段：
								<select name="currstage" id="currstage">
									<c:forEach items="${applicationScope.stages}" var="stage">
										<c:choose>
											<c:when test="${ stage.stagename eq currstage.stagename }">
												<option value="${stage.stagename}" selected="selected"> ${stage.stagenum} : ${stage.stagename} </option>
											</c:when>
											<c:otherwise>
												<option value="${stage.stagename}"> ${stage.stagenum} : ${stage.stagename} </option>
											</c:otherwise>
										</c:choose>
									</c:forEach>	
								</select>
							</td>
							<td><input class="button" type="submit" value="确认设置"/></td>
						</tr>
					</table>
				</form>
			</div>
	
			<div class="operation">阶段列表与说明（当前处于 <span style="color:#DE5B25;">&lt;&lt; ${currstage.stagename} &gt;&gt;</span> 阶段）↓：
				<span class="mess">
					<c:if test="${'stageDeleteMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			<table class="dt" border="0" cellspacing="1">
				<tr>
					<th>编号</th>
					<th>阶段名称</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>阶段说明</th>
				</tr>
				<c:forEach items="${applicationScope.stages}" var="stage" varStatus="rows">
					<tr>
						<td style="width:40px;">${stage.stagenum}</td>
						<td>${stage.stagename}</td>
						<td>${stage.starttime}</td>
						<td>${stage.endtime}</td>
						<td>${stage.note}</td>
					</tr>
				</c:forEach>
			</table>
			
			

		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
