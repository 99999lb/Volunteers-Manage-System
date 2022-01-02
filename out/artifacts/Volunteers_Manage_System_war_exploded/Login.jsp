<%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/7
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择登录方式</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<form name="login" method="post" action="servelt">
    <h1 style="text-align: center;color: aliceblue;">选择登录方式</h1>
    <table border="0" align="center" width="80%">

        <tr align="center">
            <td>
                <a href='servelt?name=al'>管理员登录</a>
            </td>
        </tr>
        <tr align="center">
            <td>
                <a href='servelt?name=cl'>普通用户登录</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
