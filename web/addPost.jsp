
<%@ page import="dao.ActivityDao" %>
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
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>发布帖子</title>
    <%
        String cid=(String) request.getSession().getAttribute("cid");
        String aid=(String) request.getSession().getAttribute("aid");
        CustomerDao cd=new CustomerDao();
        Customer c=cd.queryCustomerByCID(cid);
        String id=null;
        String name=null;
        if(cid!=null){
            id=cid;
            name=c.getCname();
        }
        else{
            id=aid;
            name="管理员";
        }
        request.setAttribute("id",id);
        request.setAttribute("name",name);
    %>
</head>
<body>
<form action="postServlet" method="post">
    <input type="hidden" name="name" value="addPost">
    <table border="1" align="center">
        <tr><td style="width: 350px;height: 80px"><h1 style="color: lightgray;" align="center">发布帖子</h1></td></tr>
    </table>
    <br><br>
    <table border="0" align="center">
        <tr><td>发帖人：</td><td><input type="text" name="pid" value="<%=id%>" readonly></td></tr>
        <tr><td>昵称：</td><td><input type="text" name="pname" value="<%=name%>" readonly></td></tr>
        <tr><td>标题：</td><td><input type="text" name="title"></td></tr>
        <tr><td>正文：</td><td><textarea rows="10" cols="60" name="tText"></textarea></td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
