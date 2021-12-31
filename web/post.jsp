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
<form method="post" action="netServlet">
    <input type="hidden" name="name" value="forum">
    <table width="60%" border="0" class="hovertable" align="center">
        <%out.print("<td><a href='addPost.jsp'>发新帖</a></td>");%>
        <%out.print("<td><a href='main.jsp'>回主界面</a></td>");%>
    </table>
    <table width="60%" border="1" class="hovertable" align="center">

        <%
            for(Post p:plist){
                out.print("<tr>");
                out.print("<td><a href='postServlet?name=deletep&tid="+p.getTid()+"'>删除帖</a></td>");
                out.print("<td><a href='postServlet?name=reply&tid="+p.getTid()+"'>"+p.getTitle()+"</a></td>");
                out.print("<td>"+p.getCname()+"</td>");
                out.print("</tr>");
            }
        %>
    </table>
</form>
</body>
</html>

