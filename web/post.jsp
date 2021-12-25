<%@ page import="dao.PostDao" %>
<%@ page import="entity.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/21
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        PostDao pd=new PostDao();
        List<Post> plist=pd.queryPostByPass();
        request.setAttribute("plist",plist);
    %>
</head>
<body>
<form name="fact" method="post" action="netServlet">
    <input type="hidden" name="name" value="forum">

    <table border="0" cellspacing="0" cellpadding="0">
        <%
            out.print("<td><a href='addPost.jsp'>发新帖</a></td>");
            for(Post p:plist){
                out.print("<tr>");
                out.print("<td>"+p.getCname()+"</td>");
                out.print("<td>"+p.getTitle()+"</td>");
                out.print("</tr>");
            }
        %>
    </table>
</form>
</body>
</html>
