<%@ page import="entity.JoinActs" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.PostDao" %>
<%@ page import="entity.Reply" %>
<%@ page import="entity.Post" %>
<%@ page import="dao.ReplyDao" %>
<%@ page import="dao.CustomerDao" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/30
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布的帖子</title>
    <%
        String cid=(String) request.getSession().getAttribute("cid");
        PostDao pd=new PostDao();
        ArrayList<Post> plist=pd.queryPostByCID(cid);

    %>
</head>
<body>
    <a href="customer.jsp">回个人主页</a>
    <form name="dPost" method="post" action="postServlet">
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>标题</th><th>正文</th><th>操作</th>
                </tr>
            </thead>
            <tbody>
            <%
                for(Post p:plist){
                    out.println("<tr>");
                    out.println("<td>"+p.getTitle()+"</td>");
                    out.println("<td>"+p.gettText()+"</td>");
                    out.println("<td><a href='postServlet?name=deletep&tid="+p.getTid()+"'>删除帖子</a></td>");
                    out.println("</tr>");
                }
            %>
            </tbody>
        </table>

    </form>
</body>
</html>
