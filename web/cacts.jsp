<%@ page import="entity.Activity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.JoinActsDao" %>
<%@ page import="dao.ActivityDao" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/26
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%--团队用户活动一览--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>
        <%
        String id= (String) request.getSession().getAttribute("cid");
        out.print(""+id);
        %>
        创建的活动
    </title>
    <script>
        var da='<%=request.getParameter("da")%>'
        if(da=="y")
            alert("活动删除成功！")
        else if(da=="n")
            alert("活动删除失败！请之后重试！")
        else if(da=="fy")
            alert("活动完成！请通知组员评分！")
        else if(da=="fn")
            alert("更新活动状态失败！请之后重试！")
    </script>
    <%
        JoinActsDao jad=new JoinActsDao();
        ActivityDao ad=new ActivityDao();
        ArrayList<Activity> alist= (ArrayList<Activity>) session.getAttribute("actsbyid");
    %>
</head>
<body>
<a href="customer.jsp">回个人主页</a>
<table border="1" align="center">
    <thead><tr><th>活动号</th><th style="width: 100px">活动名</th><th>活动类别</th>
        <th style="width: 80px">活动地点</th><th style="width: 100px">活动开始时间</th><th style="width: 100px">活动结束时间</th>
        <th style="width: 100px">招募开始时间</th><th style="width: 100px">招募结束时间</th><th>活动持续时间</th><th>所需人数</th><th>现有人数</th>
        <th style="width: 200px">活动描述</th><th>审核</th><th>活动状态</th><th>操作</th></tr>
    </thead>
    <tbody>
    <%
        if(alist!=null){
            for(Activity a:alist){
                out.println("<tr>");
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
                out.println("<td>"+jad.JoinCountByID(a.getActID())+"</td>");
                out.println("<td>"+a.getActBrif()+"</td>");
                String pass="";
                String flag=a.getPass();
                switch (flag.trim()){
                    case "Y":
                        pass="审核通过";
                        break;
                    case "N":
                        pass="待审核";
                        break;
                    case "E":
                        pass="审核不通过";
                        break;
                }
                out.println("<td>"+pass+"</td>");

                Boolean fin=ad.CheckFinAct(a.getActID());
                if(!fin){
                    switch (flag.trim()){
                        case "Y":
                            out.println("<td><a href='servelt?name=fina&finaid="+a.getActID()+"'>活动结束</a></td>");
                            break;
                        case "N":
                            out.println("<td>未开放</td>");
                            break;
                        case "E":
                            out.println("<td>未开放</td>");
                            break;
                    }
                }
                else
                    out.println("<td>活动已完成</td>");
                out.println("<td><a href='servelt?name=deletea&daid="+a.getActID()+"'>删除活动</a></td>");
                out.println("</tr>");
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
