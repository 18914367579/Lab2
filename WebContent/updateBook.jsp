<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<html>
<style type="text/css">
body {
	font-family: 微软雅黑, 宋体;
	font-size: 1.5em;
	color: white;
}
</style>
<head>
<title>修改信息</title>
</head>

<body>
	<div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="imge/image4.jpg" height="100%" width="100%" />
	</div>
	<div style="text-align: center;">
		<h2>修改信息</h2>
	</div>
	<center>
		<s:form action="updateBook">
			<s:textfield name="Title" label="书名" />
			<%-- 	<s:textfield name="AuthorID" label="作者ID"/> --%>
			<s:textfield name="Publisher" label="出版商" />
			<s:textfield name="PublishDate" label="出版日期" />
			<s:textfield name="Price" label="价格" />
			<s:submit value="修改" />
		</s:form>
	</center>
	<div style="text-align: center;">
		<a href="javascript:;" onclick="location='index.jsp'"><input
			type=button value="返回目录" /></a>
	</div>
</body>
</html>
