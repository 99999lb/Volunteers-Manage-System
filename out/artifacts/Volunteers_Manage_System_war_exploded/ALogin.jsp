<%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/7
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<script>
    var error='<%=request.getParameter("errora")%>';
    if(error=="yes")
        alert("登录失败！请检查用户名密码！")
    else if(error=="no")
        alert("登录成功！欢迎！")
</script>
<body>
<form method="post" action="servelt">
    <input type="hidden" name="name" value="alogin">
    <table align="center" border="0">
        <tr><td>用户名：</td><td><input type="text" name="an"></td><td></td></tr>
        <tr><td>密码：</td><td><input type="text" name="ap"></td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="登录"></td></tr>
    </table>
</form>
</body>
</html>
