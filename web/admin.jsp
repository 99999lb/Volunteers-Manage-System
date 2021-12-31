<%@ page import="dao.CustomerDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Customer" %>
<%@ page import="entity.Activity" %>
<%@ page import="entity.Post" %>
<%@ page import="entity.Article" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/15
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%
            String id= (String) request.getSession().getAttribute("aid");
            out.print("欢迎管理员"+id);
            pageContext.setAttribute("id",id);
        %>
    </title>
    <script>
        var passp='<%=request.getParameter("passp")%>';
        if(passp=="yes")
            alert("审核用户信息成功！数据库已更新！")
        else if(passp=="no")
            alert("审核用户信息失败！请稍后重试")
        else if(passp=="yesa")
            alert("审核志愿活动信息成功！数据库已更新！")
        else if(passp=="noa")
            alert("审核志愿活动信息失败！请稍后重试")
        else if(passp=="yest")
            alert("审核帖子信息成功！数据库已更新！")
        else if(passp=="not")
            alert("审核帖子信息失败！请稍后重试")
        else if(passp=="nn")
            alert("文章创建失败！请稍后重试")
        else if(passp=="dnn")
            alert("文章删除失败！请稍后重试")
        else if(passp=="dny")
            alert("文章删除成功！")
    </script>
    <%
        ArrayList<Customer> clist= (ArrayList<Customer>) session.getAttribute("clist");
        ArrayList<Activity> alist= (ArrayList<Activity>) session.getAttribute("alist");
        ArrayList<Post> plist=(ArrayList<Post>)session.getAttribute("plist");
        ArrayList<Article> atclist= (ArrayList<Article>) request.getSession().getAttribute("atclist");
    %>
</head>
<body>
<form name="admin" method="post" action="servelt">
    <a href="main.jsp">回主界面</a>
    <table border="1" align="center">
        <tr><td style="width: 350px;height: 80px"><h1 style="color: crimson;" align="center">管理者界面</h1></td></tr>
    </table>
    <table border="0" align="center">
        <tr>
            <td>管理员id:</td>
            <td><input type="text" name="aid" value="${id}" readonly="readonly" ></td>
        </tr>
    </table>

    <br>
    <h3 align="center" style="color: skyblue">待审核用户信息</h3>
    <table border="1" align="center">
        <thead><tr><th>账号名</th><th>用户名</th><th>性别</th><th style="width: 200px">签名</th>
            <th style="width: 150px">电话</th><th style="width: 280px">地址</th><th>用户类别</th><th>审核</th></tr></thead>
        <tbody>
        <%
            if(clist!=null){
                for(Customer c:clist){
                    out.println("<tr>");
                    out.println("<td>"+c.getCid()+"</td>");
                    out.println("<td>"+c.getCname()+"</td>");
                    out.println("<td>"+c.getSex()+"</td>");
                    out.println("<td>"+c.getSig()+"</td>");
                    out.println("<td>"+c.getPhone()+"</td>");
                    out.println("<td>"+c.getAddress()+"</td>");
                    out.println("<td>"+c.getCsort()+"</td>");
                    out.println("<td><a href='servelt?name=passp&pid="+c.getCid()+"'>审核通过</a>"+"  "
                            +"<a href='servelt?name=errorp&pid="+c.getCid()+"'>审核不通过</a></td>");
                    out.println("</tr>");
                }
            }
        %>
        </tbody>
    </table>

    <br>
    <h3 align="center" style="color: brown">待审核志愿者活动信息</h3>
    <table border="1" align="center">
        <thead><tr><th>账号名</th><th>活动号</th><th style="width: 100px">活动名</th><th>活动类别</th>
            <th style="width: 80px">活动地点</th><th style="width: 100px">活动开始时间</th><th style="width: 100px">活动结束时间</th>
            <th style="width: 100px">招募开始时间</th><th style="width: 100px">招募结束时间</th><th>活动持续时间</th><th>所需人数</th>
            <th style="width: 200px">活动描述</th><th>审核</th></tr>
        </thead>
        <tbody>
        <%
            if(alist!=null){
                for(Activity a:alist){
                    out.println("<tr>");
                    out.println("<td>"+a.getCID()+"</td>");
                    out.println("<td>"+a.getActID()+"</td>");
                    out.println("<td>"+a.getActName()+"</td>");
                    out.println("<td>"+a.getSort()+"</td>");
                    out.println("<td>"+a.getPlace()+"</td>");
                    out.println("<td>"+a.getStartTime()+"</td>");
                    out.println("<td>"+a.getEndTime()+"</td>");
                    out.println("<td>"+a.getrStartTime()+"</td>");
                    out.println("<td>"+a.getrEndTime()+"</td>");
                    out.println("<td>"+a.getDuration()+"</td>");
                    out.println("<td>"+a.getPeoNum()+"</td>");
                    out.println("<td>"+a.getActBrif()+"</td>");
                    out.println("<td><a href='servelt?name=passa&paid="+a.getActID()+"'>审核通过</a>"+"  "
                            +"<a href='servelt?name=errorpa&paid="+a.getActID()+"'>审核不通过</a></td>");
                    out.println("</tr>");
                }
            }
        %>
        </tbody>
    </table>

    <br>
    <h3 align="center" style="color: lightgray">待审核帖子信息</h3>
    <table border="1" align="center">
        <thead><tr><th>账号名</th><th>用户名</th><th style="width: 150px">帖子标题</th><th style="width: 200px;height: 60px;">帖子内容</th>
            <th>审核</th></tr>
        </thead>
        <tbody>
        <%
            if(plist!=null){
                for(Post p:plist){
                    out.println("<tr>");
                    out.println("<td>"+p.getCid()+"</td>");
                    out.println("<td>"+p.getCname()+"</td>");
                    out.println("<td>"+p.getTitle()+"</td>");
                    out.println("<td>"+p.gettText()+"</td>");
                    out.println("<td><a href='servelt?name=passt&tid="+p.getTid()+"'>审核通过</a>"+"  "
                            +"<a href='servelt?name=errort&tid="+p.getTid()+"'>审核不通过</a></td>");
                    out.println("</tr>");
                }
            }
        %>
        </tbody>
    </table>

    <br>
    <h3 align="center" style="color: plum">已发新闻</h3>
    <table align="center" border="1">
        <thead>
        <tr>
            <th>账号名</th><th>新闻号</th><th>标题</th><th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            if(atclist!=null){
                for(Article a:atclist){
                    out.println("<tr>");
                    out.println("<td>"+a.getAid()+"</td>");
                    out.println("<td>"+a.getTid()+"</td>");
                    out.println("<td>"+a.getTitle()+"</td>");
                    out.println("<td><a href='articleServlet?name=deletenews&tid="+a.getTid()+"'>删除文章</a></td>");
                    out.println("</tr>");
                }
            }
        %>
        </tbody>
    </table>
    <table border="0" align="center">
        <tr>
            <td colspan="2" align="center"><a href="addnews.jsp">发布新闻</a></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><a href="servelt?name=returnlogin">退出登录</a></td>
        </tr>
    </table>
</form>
</body>
</html>
