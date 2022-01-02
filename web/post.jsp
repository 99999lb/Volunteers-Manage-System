<%@ page import="dao.PostDao" %>
<%@ page import="entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.CustomerDao" %>
<%@ page import="entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/21
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>论坛</title>
    <link rel="stylesheet" href="css/nav.css">
    <%
        PostDao pd=new PostDao();
        List<Post> plist=pd.queryPostByPass();
        request.setAttribute("plist",plist);
    %>
</head>
<script>
    var errorp='<%=request.getParameter("pa")%>';
    if(errorp=="p")
        alert("用户信息未通过审核！请之后重试！")
    else if(errorp=="sucp")
        alert("帖子创建成功！请等待审核！")

    var p='<%=request.getParameter("p")%>';
    if(p=="y")
        alert("创建帖子成功！请等待审核")
    else if(p=="n")
        alert("创建帖子失败！请稍后重试")
</script>
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
    <h1>论坛</h1>
<form method="post" action="netServlet">
    <input type="hidden" name="name" value="forum">
    <table width="60%" border="0" class="hovertable" align="center">
        <%out.print("<td><a href='postServlet?name=post'>发新帖</a></td>");%>
        <%out.print("<td><a href='main.jsp'>回主界面</a></td>");%>
    </table>
    <table width="60%" border="0" class="hovertable" align="center">

        <%
            for(Post p:plist){
                out.print("<tr>");
                out.print("<td><a href='postServlet?name=reply&tid="+p.getTid()+"'>"+p.getTitle()+"</a></td>");
                out.print("<td>"+p.getCname()+"</td>");
                out.print("</tr>");
            }
        %>
    </table>
</form>
</div>
</body>
</html>

