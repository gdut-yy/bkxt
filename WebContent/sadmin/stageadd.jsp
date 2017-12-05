<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="阶段定义" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
<script type="text/javascript" src="${webroot}/js/sadminmanage.js"></script>
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
			
			<div class="operation">已定义阶段列表↓：
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
					<th>删除</th>
				</tr>
				<c:forEach items="${applicationScope.stages}" var="stage" varStatus="rows">
					<tr>
						<td style="width:40px;">${stage.stagenum}</td>
						<td>${stage.stagename}</td>
						<td>${stage.starttime}</td>
						<td>${stage.endtime}</td>
						<td>${stage.note}</td>
						<td style="width:40px;"><a href="${webroot}/sadmin/stageadd.do?action=stageDelete&stagenum=${stage.stagenum}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<a name="add"></a>
			<div class="operation">定义系统使用阶段↓：
				<span class="mess">
					<c:if test="${'stageAddMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			<div class="ft">
				<form method="post" action="${webroot}/sadmin/stageadd.do?action=stageAdd">
					<table>
						<tr>
							<td class="label">阶段编号：</td>
							<td><input style="width:50px;" type="text" name="stagenum" id="stagenum"/></td>
							<td class="hint"></td>
						</tr>					
						<tr>
							<td class="label">阶段名称：</td>
							<td><input type="text" name="stagename" id="stagename"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">开始时间：</td>
							<td><input type="text" name="starttime" id="starttime"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">结束时间：</td>
							<td><input type="text" name="endtime" id="endtime"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">阶段说明：</td>
							<td colspan="2">
								<textarea name="note" id="note" style="width:500px;"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input class="button" type="submit" value="确认添加"/></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
