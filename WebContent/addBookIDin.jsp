<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
  <style type="text/css">
body
{
font-family : 微软雅黑,宋体;
font-size : 1.5em;
color : white;
}
</style>
    <title>添加图书</title>

  </head>
  
  <body>

  <div id="formbackground" style="position:absolute; width:100%; height:100%; z-index:-1">  
  	<img src="imge/image2.jpg" height="100%" width="100%"/>  
  </div> 
  <div style="text-align:center;">
    <h2>请输入作者ID</h2>
    </div>
    <br>
       <br>
  	<%-- <s:property value="tips"/> --%>
  <center>
    <s:form action="checkID"  >
    	<s:textfield name="AuthorID" label="作者ID"/>
    	<div align="center">
    	<s:submit value="确认"/>
    	</div>
    </s:form>
   </center>
    <div style="text-align:center;">
    <a href="javascript:;"onclick="location='index.jsp'" ><input type=button value="返回目录" /></a>
 	</div>
  </body>
</html>