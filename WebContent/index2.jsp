<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>考生登录</title>
	<link rel="stylesheet" type="text/css" href="./styles/basic.css">
	<script type="text/javascript" src="/bkxt/js/index.js"></script>   
  </head>
  
  <body>
    <%@ include file="./includes/header.jsp"%>
    
    <div id="content">
    	<div id="left">
    		<h1>用户登录入口</h1>
    		
    		<div id="menu">
					<a href="notice.jsp">报考须知</a>
					<a href="entry.jsp">填写报名表</a>
					<a href="upload.jsp">上传照片</a>
					<a href="table.jsp">打印报名表</a>
					<a href="print.jsp">打印准考证</a>
					<a href="rsquery.jsp">成绩查询</a>
				</div>
    	
    	</div>
    	
    	<div id="right">
    		<h1>系统使用说明</h1>
    		<div id="hmenu">
		<ul>
			<li><a href="/gzcx/login?action=quit" target="_top">退出</a></li>
			<li><a href="/gzcx/suser/modifypass.jsp" target="_self">修改密码</a></li>
			<li><a href="/gzcx/suser/modifypass.jsp" target="_self">登录历史</a></li>
			<li><span>欢迎您：${sessionScope.suser.name }</span></li>
		</ul>
	</div>
    		
    		<h2>使用说明</h2>
    		<p>sfdfdfsd</p>
    		
    		<table class="dt" border="0" cellspacing="1">
				<tr>
					<th>学年</th>
					<th>学期</th>
					<th>课程名称</th>
					<th>课程性质</th>	
					<th>学分</th>
					<th>绩点</th>
					<th>成绩</th>
					<th>补考成绩</th>
					<th>重修成绩</th>
					<th>辅修标记</th>
					<th>备注</th>
				</tr>
				
				<tr>
					<td>sdfsdf</td>
					<td>sdf水电费</td>			
					<td>地方</td>
					<td>地方</td>			
					<td>电饭锅</td>
					<td>儿童</td>
					<td>儿童</td>
					<td>儿童</td>
					<td>儿童</td>
					<td>wer</td>
					<td>各环节</td>
				</tr>
				<tr>
					<td>sdfsdf</td>
					<td>sdf水电费</td>			
					<td>地方</td>
					<td>地方</td>			
					<td>电饭锅</td>
					<td>儿童</td>
					<td>儿童</td>
					<td>儿童</td>
					<td>儿童</td>
					<td>wer</td>
					<td>各环节</td>
				</tr>		
		</table>
    	
    <div class="operation">在此添加普通员工↓：<span id="mess">信息 </span></div>

	<div class="ft">
		<form id="addform" method="post" action="/gzcx/admin/staff?action=addStaff">
			<table>
				<tr>
					<td>身份证号：<input type="text" name="idcode" id="newidcode" /></td>
					<td>姓名：<input type="text" name="name" id="newname" /></td>
				
					<td><input type="submit" value="添 加" class="button" /></td>
				</tr>
			</table>
		</form>
	</div>
    		
    		
    	</div>
    
    	<div class="clearf"></div>
    </div>
    
    <%@ include file="./includes/footer.jsp" %>
  </body>
</html>
