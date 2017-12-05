<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <c:set var="title" value="报名表打印" />
		<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/printtable.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/basic.js"></script>   
  </head>  
 <body>
			<div id="infocard">
		<div id="header">2016年天津理工大学中环信息学院专升本考试</div>
			<div id="photoline">
				<div id="ulline">
					<ul>
						<li class="label">==报考信息==</li>
						<li><b>报考专业：${reginfo.mname}</b></li>
						<li class="label">==个人信息==</li>
						<li><b>姓名：${reginfo.sname}</b></li>
					</ul>
				</div>
				<div id="photo"><img width="115px" height="135px" src="../upload/${reginfo.username}.jpg" /></div>
			</div>
			<div id="center">
				<ul>
					<li><b>性别：${reginfo.ssex}</b></li>
					<li><b>民族：${reginfo.nation}</b></li>
					<li><b>政治面貌：${reginfo.political}</b></li>
					<li><b>身份证号：${reginfo.idcode}</b></li>
					<li><b>生源地：${reginfo.source}</b></li>
					<li><b>家庭住址：${reginfo.homeaddr}</b></li>
					<li><b>毕业院校：${reginfo.school}</b></li>
					<li><b>是否应届：${reginfo.isnew}</b></li>
					<li><b>毕业时间：${reginfo.gradutetime}</b></li>
					<li><b>文理科：${reginfo.aos}</b></li>
					<li><b>所学专业：${reginfo.major}</b></li>
					<li><b>英语水平：${reginfo.cet}</b></li>
					<li class="label">==联系人信息==</li>
					<li><b>收件人姓名：${reginfo.receiver}</b></li>
					<li><b>收信地址：${reginfo.conaddr}</b></li>
					<li><b>邮政编码：${reginfo.zipcode}</b></li>
					<li><b>手机号码：${reginfo.mobile}</b></li>
					<li><b>备用电话：${reginfo.telphone}</b></li>
					<li class="label">==本人承诺==</li>	
				</ul>
			</div>
			<div id="footer">
				<p>本报名表所有信息准确无误，照片真实有效，若有虚假，所产生的后 果由本人承担。</p>
				<p class="rp">报名人（签名）：&nbsp;&nbsp;&nbsp;				
				<p class="rp">&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日</p>
			</div>
		</div>
	  </body>
</html>
