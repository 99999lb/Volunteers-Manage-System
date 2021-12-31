<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Article" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/31
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览文章</title>
</head>
<%
    ArrayList<Article> list= (ArrayList<Article>) request.getSession().getAttribute("actlist");
%>
<body>
<form action="articleServlet" method="post">
    <a href="news.jsp">返回新闻一览</a>
    <table border="1" align="center">
        <thead><tr ><th><%
            out.println("<h1>"+list.get(0).getTitle()+"</h1>");
        %></th></tr></thead>
        <tbody><%
            String text=list.get(0).gettText();
            String[] t=text.split("\n");
            out.println("<tr style='border: 0' align='center'><td style='border: 0'>"+t[0]+"</td></tr>");
            out.println("<tr style='border: 0'><td style='border: 0'>");
            for(int i=1;i<t.length;i++){
                out.println(t[i]);
                out.println("<br>");
            }
            out.println("</td></tr>");
        %>
       </tbody>
    </table>
</form>
</body>
</html>
