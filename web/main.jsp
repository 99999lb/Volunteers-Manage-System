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
    <link rel="stylesheet" href="css/login.css">
</head>
<style>
    body {
        margin: 0;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 150%;
        background-color: #e8e8e8;
        position: center;
        height:40%;
        overflow: auto;
    }

    li a {
        display: block;
        color: #000;
        padding: 8px 16px;
        text-decoration: none;
    }

    li a.active {
        background-color: #00bcd4;
        color: white;
    }

    li a:hover:not(.active) {
        background-color: #555;
        color: white;
    }
</style>
<script>
    var error='<%=request.getParameter("errorm")%>';
    if(error=="nologin")
        alert("请先登录！")
</script>
<body>
<form method="post" action="servelt">
    <ul>
        <h1 style="text-align: center;color: #364563;">志愿者</h1>
        <li><a href="netServlet?name=acts">志愿活动</a></li>
        <li><a href="netServlet?name=news">新闻报道</a></li>
        <li><a href="netServlet?name=forum">志愿者论坛</a></li>
        <li><a href="netServlet?name=pac">志愿者培训</a></li>
        <li><a href="netServlet?name=download">文件下载</a></li>
        <li><%
            String cid= (String) request.getSession().getAttribute("cid");
            String aid= (String) request.getSession().getAttribute("aid");
            if(cid==null && aid==null)
                out.println("<a href='Login.jsp'>登录</a>");
            else if(cid!=null)
                out.println("<a href='customer.jsp'>用户中心"+cid+"</a>");
            else if(aid!=null)
                out.println("<a href='admin.jsp'>管理员中心"+aid+"</a>");
        %></li>
    </ul>

</form>
</body>
</html>
