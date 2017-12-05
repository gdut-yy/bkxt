<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="管理登录" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${webroot}/styles/basic.css" />
	<script type="text/javascript" src="${webroot}/js/manage.js"></script>
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
			
			<div class="operation">各专业报考信息列表列表↓：</div>
				<table class="dt" border="0" cellspacing="1">
					<tr>
						<th>专业名称</th>
						<th>计划招生人数</th>
						<th>实际报考人数</th>
						<th>录取人数</th>
					</tr>
					<c:forEach items="${majors}" var="major" varStatus="rows">
						<tr>
							<td>${major.mname}</td>
							<td>${major.plannum}</td>
							<td>${major.applynum}</td>
							<td>${major.admitnum}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<form action= "${pageContext.request.contextPath}/admin/reginfomanage.do" method="post">
					<table>
								<tr>
									<td class="label">报考专业：</td>
									<td>
										<select name="mname" id="mname">
											<option value="all" selected='selected'>全部</option>		
											<c:forEach items="${applicationScope.majors}" var="major">
												<option value="${major.mname}">${major.mname}</option>
											</c:forEach>	
										</select>
									</td>
									<td></td>
									<td class="label">是否确认：</td>
									<td>
										<select name="isconfirm" id="isconfirm">
													<option value="all" selected='selected'>全部</option>
													<option value="true">已确认</option>
													<option value="false">未确认</option>
										</select>
									</td>
									<td><input class="button" type="submit" name="submit" value="查询" id="submit" />
								</tr>
					</table>
				</form>
					<table class="dt" border="0" cellspacing="1">
						<tr>
							<th>身份证号</th>
							<th>考生姓名</th>
							<th>考生性别</th>
							<th>报考专业</th>
							<th>是否确认</th>
						</tr>
						<c:forEach items="${pm.data}" var="reginfo" varStatus="rows">
							<tr>
								<td>${reginfo.idcode}</td>
								<td>${reginfo.sname}</td>
								<td>${reginfo.ssex}</td>
								<td>${reginfo.mname}</td>
								<td>${reginfo.isconfirm}</td>
							</tr>
						</c:forEach>
					</table>
					<div class="pagenav">${pm.pageNav}</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
