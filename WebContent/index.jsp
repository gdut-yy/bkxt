<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="title" value="考生登录" />
<c:set var="webroot" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新用户注册</title>
    <link rel="stylesheet" type="text/css" href="./styles/basic.css" />
</head>
<body>
    <%@ include file="./includes/header.jsp"%>
	
	<div id="content">
		 <div id="left">
			<h1>系统使用说明</h1>
			<div class="ft" style="border: none;">
				<table>
					<tr><td>1、还没有账号，<a href="${webroot}/register.jsp">点此注册</a>！</td></tr>
					<tr><td>2、已有账号，在本页面右侧登录！</td></tr>
					<tr><td>3、登陆成功后，根据页面左侧“报考步骤”中的菜单按步骤进行报名！</td></tr>
					<tr><td>4、咨询电话：${applicationScope.school.shtel}</td></tr>
				</table>
			</div>
		</div>

		<div id="right">
			<h1>${title}</h1>
			<div class="operation">验证登录信息↓：
				<span class="mess" id="stuLoginMess">${requestScope.stuLoginMess}</span>
			</div>
			<div class="ft">
				<form method="post" action="${webroot}/login.do">
					<table>
						<tr>
							<td class="label">用户名：</td>
							<td colspan="2"><input type="text" name="username" id="username" value="${ requestScope.username }" /></td>
							<td class="hint">*</td>
						</tr>
						<tr>
							<td class="label">密码：</td>
							<td colspan="2"><input type="password" name="password" id="password" value="${ requestScope.password }" /></td>
							<td class="hint">*</td>
						</tr>
						<tr>
							<td class="label">验证码：</td>
							<td><input style="width: 65px;" type="text" name="code" id="code" value="${ requestScope.code }" /></td>
							<td><img src="${webroot}/includes/code.jsp" id="imagecode" title="点击可更换" onclick="this.src='${webroot}/includes/code.jsp?tm='+ Math.random();"/></td>
							<td class="hint">*</td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="submit" value="登录系统" class="button" id="submit" />
								<input type="reset" value="重 置" class="button" id="reset" />
							</td>
							<td class="hint">* 还没有账号，<a href="${webroot}/register.jsp">点此注册</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div class="clearf"></div>

	</div>

	<%@ include file="./includes/footer.jsp"%>
</body>
</html>