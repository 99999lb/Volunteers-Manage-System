<%@ page import="dao.CustomerDao" %>
<%@ page import="entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/21
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布新闻</title>
    <%
        String aid=(String) request.getSession().getAttribute("aid");
    %>
</head>
<body>
<form action="articleServlet" method="post">
    <input type="hidden" name="name" value="addnews">
    <table border="1" align="center">
        <tr><td style="width: 350px;height: 80px"><h1 style="color: lightgray;" align="center">发布新闻</h1></td></tr>
    </table>
    <br><br>
    <table border="0" align="center">
        <tr><td>发帖人：</td><td><input type="text" readonly="readonly" style="border: 0px" name="aid" value="${aid}" readonly></td></tr>
        <tr><td>标题：</td><td ><input type="text" name="title" style="width: 300px"></td></tr>
        <tr><td>正文：</td><td><textarea rows="10" cols="60" name="tText"></textarea></td></tr>
        <tr><td colspan="2">*文章第一行默认标题/时间日期，请确保输入格式正确。</td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>