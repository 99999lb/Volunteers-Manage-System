<%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/12
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新个人信息</title>
</head>
<body>
<form method="post" action="servelt">
    <table border="1" align="center">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="cname"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>男<input type="radio" name="sex" value="男" checked>女<input type="radio" name="sex" value="女"></td>
        </tr>
        <tr>
            <td>签名</td>
            <td><input type="text" name="sig" ></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="ads" ></td>
        </tr>
        <tr>
            <td>志愿者类别</td>
            <td>个体<input type="radio" name="sort" value="P" checked>团体<input type="radio" name="sort" value="C"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
