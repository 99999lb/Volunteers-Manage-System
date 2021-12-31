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
    <title>新闻一览</title>
</head>
<script>
    var p='<%=request.getParameter("p")%>';
    if(p=="y")
        alert("新闻发布成功！")
</script>
<%
    ArrayList<Article> list= (ArrayList<Article>) request.getSession().getAttribute("atclist");
%>
<body>
<form action="articleServlet" method="post">
    <a href="main.jsp">回主界面</a>
    <table align="center" border="1">
        <thead>
        <tr>
            <th align="center">新闻标题</th>
        </tr>
        </thead>
        <%
            if(list!=null){
                for(Article a:list){
                    out.print("<tr align='center'>");
                    out.print("<td ><a href='articleServlet?name=browse&tid="+a.getTid()+"'>"+a.getTitle()+"</a></td>");
                    out.print("</tr>");
                }
            }
        %>
    </table>
</form>
</body>
</html>
