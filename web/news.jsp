<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Article" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/31
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <link rel="stylesheet" href="css/nav.css">
    <title>新闻一览</title>
</head>
<script>
    var p='<%=request.getParameter("p")%>';
    if(p=="y")
        alert("新闻发布成功！")
    else if(p=="py")
        alert("志愿者训练文章发布成功！")
</script>
<%
    ArrayList<Article> list= (ArrayList<Article>) request.getSession().getAttribute("atclist");
%>
<body>
<ul>
    <li><a href="main.jsp">主页</a></li>
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
<div style="margin-left:25%;padding:1px 16px;height:1000px;">
<form action="articleServlet" method="post">
    <a href="main.jsp">回主界面</a>
    <table align="center" border="1">
        <thead>
        <tr>
            <th align="center"><%
                String sort=request.getParameter("n");

                switch (sort){
                    case "n":
                        out.println("新闻标题");
                        break;
                    case "p":
                        out.println("志愿者培训文章标题");
                        break;
                }
            %></th>
        </tr>
        </thead>
        <%
            if(list!=null){
                for(Article a:list){
                    out.print("<tr align='center'>");
                    out.print("<td ><a href='articleServlet?name=browse&s="+sort+"&tid="+a.getTid()+"'>"+a.getTitle()+"</a></td>");
                    out.print("</tr>");
                }
            }
        %>
    </table>
</form>
</div>
</body>
</html>
