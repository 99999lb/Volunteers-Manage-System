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
    <title>注册账号</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<script>
    var error='<%=request.getParameter("errorR")%>';
    if(error=="y1")
        alert("注册失败！两次输入的密码不一致！");
    else if(error=="y2")
        alert("注册失败！已经存在相同的账号名！");
</script>
<body>
    <form method="post" action="servelt">
        <h1 style="text-align: center;color: aliceblue;">用户注册</h1>
        <input type="hidden" name="name" value="cregister">
        <table border="0" align="center">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="cid"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="cpwd"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="text" name="cc"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</body>
</html>
