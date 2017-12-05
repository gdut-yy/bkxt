<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="招考信息设置" />
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

			<div class="operation">设置学校基本信息↓：
				<span class="mess">
					<c:if test="${'schoolAddMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			
			<div class="ft">
				<form method="post" action="${webroot}/zadmin/release.do?action=schoolAdd">
					<table>
						<tr>
							<td class="label">学校代码：</td>
							<td><input style="width:50px;" type="text" name="shcode" id="shcode" value="${applicationScope.school.shcode}"/></td>
							<td class="hint"></td>
						</tr>					
						<tr>
							<td class="label">学校名称：</td>
							<td><input class="long" type="text" name="shname" id="shname" value="${applicationScope.school.shname}"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">学校地址：</td>
							<td><input class="long" type="text" name="shaddr" id="shaddr" value="${applicationScope.school.shaddr}"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">邮编：</td>
							<td><input type="text" name="shzip" id="shzip" value="${applicationScope.school.shzip}"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">联系电话：</td>
							<td><input type="text" name="shtel" id="shtel" value="${applicationScope.school.shtel}"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">考试名称：</td>
							<td><input type="text" name="shtest" id="shtest" value="${applicationScope.school.shtest}"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td class="label">招生年份：</td>
							<td><input type="text" name="shyear" id="shyear" value="${applicationScope.school.shyear}"/></td>
							<td class="hint"></td>
						</tr>
						<tr>
							<td colspan="2"><input class="button" type="submit" value="确认设置"/></td>
						</tr>
					</table>
				</form>
			</div>

			<a name="major"></a>
			<div class="operation">已添加的专业列表↓：
				<span class="mess">
					<c:if test="${'majorDeleteMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			<table class="dt" border="0" cellspacing="1">
				<tr>
					<th>序号</th>
					<th>专业代码</th>
					<th>专业名称</th>
					<th>计划录取人数</th>
					<th>删除专业</th>
				</tr>
				<c:forEach items="${applicationScope.majors}" var="major" varStatus="rows">
					<tr>
						<td>${rows.index + 1}</td>
						<td>${major.mcode}</td>
						<td>${major.mname}</td>
						<td>${major.plannum}</td>
						<td><a href="${webroot}/zadmin/release.do?action=majorDelete&mcode=${major.mcode}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			
			<div class="operation">添加新专业↓：
				<span class="mess">
					<c:if test="${'majorAddMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			<div class="ft">
				<form method="post" action="${webroot}/zadmin/release.do?action=majorAdd">
					<table>
						<tr>
							<td class="label">专业代码：</td>
							<td><input style="width:50px;" type="text" name="mcode" id="mcode" /></td>
							<td class="label">专业名称：</td>
							<td><input style="width:250px;" type="text" name="mname" id="mname" /></td>
							<td class="label">计划录取人数：</td>
							<td><input style="width:50px;" type="text" name="plannum" id="plannum" /></td>
							<td><input class="button" type="submit" value="确认添加"/></td>
						</tr>
					</table>
				</form>
			</div>
			
			<a name="course"></a>
			<div class="operation">已添加的考试课程列表↓：
				<span class="mess">
					<c:if test="${'courseDeleteMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			<table class="dt" border="0" cellspacing="1">
				<tr>
					<th>序号</th>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>隶属专业</th>
					<th>考试开始时间</th>
					<th>考试结束时间</th>
					<th>删除课程</th>
				</tr>
				<c:forEach items="${applicationScope.courses}" var="course" varStatus="rows">
					<tr>
						<td>${rows.index + 1}</td>
						<td>${course.ccode}</td>
						<td>${course.cname}</td>
						<td>${course.cmname}</td>
						<td>${course.cstarttime}</td>
						<td>${course.cendtime}</td>
						<td><a href="${webroot}/zadmin/release.do?action=courseDelete&ccode=${course.ccode}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="operation">添加新课程↓：
				<span class="mess">
					<c:if test="${'courseAddMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
				</span>
			</div>
			<div class="ft">
				<form method="post" action="${webroot}/zadmin/release.do?action=courseAdd">
					<table>
						<tr>
							<td class="label">课程编号：</td>
							<td><input style="width:50px;" type="text" name="ccode" id="ccode" /></td>
						</tr>
						<tr>
							<td class="label">课程名称：</td>
							<td><input style="width:250px;" type="text" name="cname" id="cname" /></td>
						</tr>
						<tr>
							<td class="label">隶属专业：</td>
							<td>
								<select name="cmname" id="cmname">
									<c:forEach items="${applicationScope.majors}" var="major">
										<option value="${major.mname}">${major.mname}</option>
									</c:forEach>	
								</select>
						</tr>
						<tr>
							<td class="label">考试开始时间：</td>
							<td><input style="width:250px;" type="text" name="cstarttime" id="cstarttime" /></td>
						</tr>
						<tr>
							<td class="label">考试结束时间：</td>
							<td><input style="width:250px;" type="text" name="cendtime" id="cendtime" /></td>
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
