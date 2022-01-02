<%@ page import="dao.CustomerDao" %>
<%@ page import="entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/12
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>更新个人信息</title>
</head>
<script>
    var upd='<%=request.getParameter("upd")%>'
    if(upd=="false")
        alert("信息更新失败！请重试！")
</script>
<body>
<a href="customer.jsp">回上一页</a>
<form method="post" action="servelt">
    <input type="hidden" name="name" value="renew">
    <table border="1" align="center">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="rcname"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>男<input type="radio" name="rsex" value="男" checked>女<input type="radio" name="rsex" value="女"></td>
        </tr>
        <tr>
            <td>签名</td>
            <td><input type="text" name="rsig" style="width: 200px;height: 40px;font-size: 10px"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="rphone" maxlength="11"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="rads" style="width: 380px;height: 40px;font-size: 10px"></td>
        </tr>
        <tr>
            <td>志愿者类别</td>
            <td>个体<input type="radio" name="rsort" value="P" checked>团体<input type="radio" name="rsort" value="C"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
