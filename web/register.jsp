<%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/10
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="servelt">
        <input type="hidden" name="name" value="cregister">
        <table border="1" align="center">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="cid"></td>
            </tr>
            <tr>0
                <td>姓名</td>
                <td><input type="text" name="cname"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="sex"></td>
            </tr>
            <tr>
                <td>签名</td>
                <td><input type="text" name="sig"></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="cpwd"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
