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
</head>
<body>
<form name="login" method="post" action="servelt">
    <table border="1" align="center">
        <tr>
            <td>
                <a href='servelt?name=al'>Admin Login</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href='servelt?name=cl'>Customer Login</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
