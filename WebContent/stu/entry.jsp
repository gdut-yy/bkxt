<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<c:set var="title" value="我的报名信息" />
<title>${title}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/basic.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/basic.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/entry.js"></script>
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

			<c:choose>
				<c:when test="${applicationScope.currstage.stagename != '在线报名'}">
					<table>
						<tr>
							<td>现在未开放在线报名功能。</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<div class="operation">
						请您认真填写报考信息：↓ <span class="mess" id="entryMess"></span>
					</div>
					<div class="ft">
						<form method="post"
							action="${pageContext.request.contextPath}/stu/entry.do?action=entry">
							<fieldset>
								<legend> 报考信息 </legend>
								<table>
									<tr>
										<td class="label">报考专业：</td>
										<td><select name="mname" id="mname">
												<c:forEach items="${applicationScope.majors}" var="major">
													<c:choose>
														<c:when
															test="${major.mname == requestScope.reginfo.mname}">
															<option value="${major.mname}" selected='selected'>${major.mname}</option>
														</c:when>
														<c:otherwise>
															<option value="${major.mname}">${major.mname}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
										</select></td>
									</tr>
								</table>
							</fieldset>

							<fieldset>
								<legend> 个人基本信息 </legend>

								<table>

									<tr>
										<td class="label">姓名：</td>
										<td><input type="text" name="sname" id="sname"
											value="${requestScope.reginfo.sname}" />
										</td>
									</tr>
									<tr>
										<td class="label">性别：</td>
										<td><select name='ssex' id='gender'>
												<c:choose>
													<c:when test="${requestScope.reginfo.ssex == '女'}">
														<option value='女' selected='selected'>女</option>
														<option value='男'>男</option>
													</c:when>
													<c:otherwise>
														<option value='男' selected='selected'>男</option>
														<option value='女'>女</option>
													</c:otherwise>
												</c:choose>
										</select></td>
									</tr>
									<tr>
										<td class="label">民族：</td>
										<td><input type="text" name="nation" id="nation"
											value="${requestScope.reginfo.nation}" />
										</td>
									</tr>
									<tr>
										<td class="label">身份证号：</td>
										<td><input type="text" name="idcode" id="idcode"
											value="${requestScope.reginfo.idcode}" />
										</td>
									</tr>
									<tr>
										<td class="label">政治面貌：</td>
										<td><input type="text" name="political" id="political"
											value="${requestScope.reginfo.political}" />
										</td>
									</tr>
									<tr>
										<td class="label">生源地：</td>
										<td><input type="text" name="source" id="source"
											value="${requestScope.reginfo.source}" />
										</td>
									</tr>
									<tr>
										<td class="label">家庭住址：</td>
										<td><input type="text" name="homeaddr" id="homeaddr"
											value="${requestScope.reginfo.homeaddr}" />
										</td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend> 教育背景 </legend>

								<table>

									<tr>
										<td class="label">毕业院校：</td>
										<td><input type="text" name="school" id="school"
											value="${requestScope.reginfo.school}" />
										</td>
									</tr>
									<tr>
										<td class="label">毕业时间：</td>
										<td><input type="text" name="gradutetime"
											id="gradutetime" value="${requestScope.reginfo.gradutetime}" />
										</td>
									</tr>
									<tr>
										<td class="label">是否应届：</td>
										<td><select name='isnew' id='is_new'>
												<c:choose>
													<c:when test="${requestScope.reginfo.isnew == '往届'}">
														<option value='往届' selected='selected'>往届</option>
														<option value='应届'>应届</option>
													</c:when>
													<c:otherwise>
														<option value='应届' selected='selected'>应届</option>
														<option value='往届'>往届</option>
													</c:otherwise>
												</c:choose>
										</select></td>
									</tr>
									<tr>
										<td class="label">文理科：</td>
										<td><select name='aos' id='aos'>
												<c:choose>
													<c:when test="${requestScope.reginfo.aos == '文科'}">
														<option value='文科' selected='selected'>文科</option>
														<option value='理科'>理科</option>
													</c:when>
													<c:otherwise>
														<option value='理科' selected='selected'>理科</option>
														<option value='文科'>文科</option>
													</c:otherwise>
												</c:choose>
										</select></td>
									</tr>
									<tr>
										<td class="label">所学专业：</td>
										<td><input type="text" name="major" id="major"
											value="${requestScope.reginfo.major}" />
										</td>
									</tr>
									<tr>
										<td class="label">英语水平：</td>
										<td><select name="cet" id="cet">
												<c:choose>
													<c:when test="${requestScope.reginfo.cet == 'cet6'}">
														<option value="cet6" selected="selected">大学英语6级</option>
														<option value="cet4">大学英语4级</option>
													</c:when>
													<c:otherwise>
														<option value="cet4" selected="selected">大学英语4级</option>
														<option value="cet6">大学英语6级</option>
													</c:otherwise>
												</c:choose>
										</select></td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend>联系方式 </legend>

								<table>

									<tr>
										<td class="label">收信人姓名：</td>
										<td><input type="text" name="receiver" id="receiver"
											value="${requestScope.reginfo.receiver}" />
										</td>
									</tr>
									<tr>
										<td class="label">收信地址：</td>
										<td><input type="text" name="conaddr" id="conaddr"
											value="${requestScope.reginfo.conaddr}" />
										</td>
									</tr>
									<tr>
										<td class="label">邮政编码：</td>
										<td><input type="text" name="zipcode" id="zipcode"
											value="${requestScope.reginfo.zipcode}" />
										</td>
									</tr>
									<tr>
										<td class="label">联系电话：</td>
										<td><input type="text" name="telphone" id="telphone"
											value="${requestScope.reginfo.telphone}" />
										</td>
									</tr>
									<tr>
										<td class="label">移动电话：</td>
										<td><input type="text" name="mobile" id="mobile"
											value="${requestScope.reginfo.mobile}" />
										</td>
									</tr>
								</table>
							</fieldset>
							<table>
								<tr>
									<td colspan="2"><input type="submit" value="保存并下一步"
										class="button" />
									</td>
								</tr>
							</table>
						</form>
					</div>
				</c:otherwise>
			</c:choose>


		</div>
		<div class="clearf"></div>
	</div>

	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
