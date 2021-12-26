<%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/20
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>志愿服务网</title>
</head>
<body>
<form method="post" action="servelt">
    <table border="1" align="center" width="80%">
        <tr><td width="70%"><h1>志愿服务网</h1></td>
            <td align="center">
                <%
                    String cid= (String) request.getSession().getAttribute("cid");
                    String aid= (String) request.getSession().getAttribute("aid");
                    if(cid==null && aid==null)
                        out.println("<a href='Login.jsp'>登录</a>");
                    else if(cid!=null)
                        out.println("<a href='customer.jsp'>用户"+cid+"</a>");
                    else if(aid!=null)
                        out.println("<a href='admin.jsp'>管理员"+aid+"</a>");
                %></td></tr>
    </table>
    <table border="1" align="center" style="width: 90%;height: 40%">
        <tr><td align="center"><a href="netServlet?name=acts">志愿活动</a></td>
            <td align="center"><a href="netServlet?name=news">新闻报道</a></td>
            <td align="center"><a href="netServlet?name=forum">志愿者论坛</a></td>
            <td align="center"><a href="netServlet?name=pac">志愿者培训</a></td>
            <td align="center"><a href="netServlet?name=download">文件下载</a></td></tr>
    </table>
</form>
</body>
</html>
