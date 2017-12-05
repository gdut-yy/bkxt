<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<c:set var="title" value="上传照片" />
<title>${title}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/basic.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/basic.js"></script>
</head>

<body>
	<%@ include file="../includes/header.jsp"%>

	<div id="content">
		<div id="left">
			<h1>报考步骤</h1>
			<%@ include file="../includes/stu/menu.jsp"%>
		</div>

		<div id="right">
			<c:choose>
				<c:when test="${applicationScope.currstage.stagename != '在线报名'}">
					<table>
						<tr>
							<td>现在未开在线报名功能。</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<h1>${title}</h1>
					<%@ include file="../includes/stu/hmenu.jsp"%>
					<div class="operation">请您仔细阅读照片上传要求：↓</div>
					<div class="ft">
						<table>
							<tr>
								<td>1、考生上传电子版照片必须为近期免冠正面证件照并且能够清晰的反映本人特征，红底、蓝底均可，jpg格式，照片尺寸宽高比例大约为1.3:1.6，大小为130×160像素左右，50kb以下，最终效果以输出后的大小为准。</td>
							</tr>
							<tr>
								<td>2、考生上传的电子照片如果不符合要求，可通过PHOTOSHOP等图像处理软件改变图像格式及大小。</td>
							</tr>
							<tr>
								<td>3、考生一定不要直接修改其它格式照片的扩展名为
									.jpg，要使用PHOTOSHOP等图像处理软件改变图像格式，否则上传不成功。</td>
							</tr>
							<tr>
								<td>4、操作说明：考生在下面的照片框下，点击“浏览”按钮，按上述要求选择处理好的照片，然后点击“点击上传”按钮，如果上传成功但是未看到上传的照片出现在上面的照片框内，则点击“照片预览”按钮，将会显示您上传的照片，如果不符合要求，请重新上传您的照片。</td>
							</tr>
						</table>

						<form action="${pageContext.request.contextPath}/stu/photo.do"
							method="post" name="upload" ENCTYPE="multipart/form-data">
							<table style="margin:0 auto;">
								<tr>
									<td><div
											style="margin:0 auto;background:url(../upload/${username}.jpg) no-repeat center center;width:145px;height:175px;border:2px solid #999;"></div>
									</td>
								</tr>
								<tr>
									<td style="text-align:center;"><input type="file"
										name="file1" id="file1" size="20" id="file1"
										style="border:1px solid #999;" /></td>
								</tr>
								<tr />
								<tr>
									<td style="text-align:center;"><input class="button"
										type="submit" name="submit" value="点击上传" id="submit" /> <input
										class="button" type="button" value="照片预览"
										onclick="window.location.reload()" />
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
