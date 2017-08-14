<%@ page import="org.springframework.web.bind.annotation.RequestParam" %><%--
  Created by IntelliJ IDEA.
  User: LZP
  Date: 2017/8/7
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="serForm" action="/web1/fileUpload" method="post"  enctype="multipart/form-data">
    <h1>采用流的方式上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>


<form name="Form2" action="/web1/fileUpload2" method="post"  enctype="multipart/form-data">
    <h1>采用multipart提供的file.transfer方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>
<form name="Form2" action="/web1/fileUpload3" method="post"  enctype="multipart/form-data">
    <h1>使用spring mvc提供的类的方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>
<%
    String s = request.getParameter("userName");
    System.out.println(s);
%>
<%=s%>
</body>
</html>
