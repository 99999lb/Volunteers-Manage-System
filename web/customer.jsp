<%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/13
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%
            String id= (String) request.getSession().getAttribute("id");
            out.print("欢迎用户"+id);
        %>
    </title>
</head>
<body>

<form name="customer" method="post" action="servelt">
    <table border="1" align="center">
        <tr>
            <td>
                <a href='servelt?name=vact'>活动参与</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href='servelt?name=vpost'>发布帖子</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href='servelt?name=fact'>已完成活动</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href='servelt?name=cinfo'>个人信息</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
