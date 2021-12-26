
<%@ page import="dao.ActivityDao" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/21
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布帖子</title>
    <%
        String id= (String) request.getSession().getAttribute("cid");
        ActivityDao ad=new ActivityDao();
    %>
</head>
<body>
<form action="servelt" method="post">
    <input type="hidden" name="name" value="vpost">
    <table border="1" align="center">
        <tr><td style="width: 350px;height: 80px"><h1 style="color: lightgray;" align="center">发布帖子</h1></td></tr>
    </table>
    <br><br>
    <table border="0" align="center">
        <tr><td>发帖人：</td><td><%--此处通过session获得参数 --%><%= (String) request.getSession().getAttribute("cid")%></td></tr>
        <tr><td>昵称：</td><td><input type="text" name="cname" maxlength="10"></td></tr>
        <tr><td>标题：</td><td><input type="text" name="title"></td></tr>
        <tr><td>正文：</td><td><textarea rows="10" cols="60" name="tText"></textarea></td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
