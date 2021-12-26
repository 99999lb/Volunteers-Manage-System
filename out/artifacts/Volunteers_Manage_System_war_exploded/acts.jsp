<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Activity" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/21
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>志愿者活动一览</title>
</head>
<script>
    var error='<%=request.getParameter("ca")%>';
    if(error=="ebs")
        alert("个体用户不可创建志愿者活动！请尝试申请为团体用户！")
    else if(error=="p")
        alert("用户信息未通过审核！请之后重试！")
    else if(error=="sucs")
        alert("活动创建成功！请等待审核！")
    else if(error=="admin")
        alert("管理员账户不可创建志愿者活动！请切换为个体账户后重试！")

    var ja='<%=request.getParameter("ja")%>';
    if(ja=="adm" || ja=="c")
        alert("仅个体用户才能参加志愿者活动！")
    else if(ja=="y")
        alert("活动参加成功！请注意活动开始时间！")
    else if(ja=="n")
        alert("活动参加失败！请稍后重试！")
</script>
<%
    ArrayList<Activity> passalist= (ArrayList<Activity>) request.getSession().getAttribute("passalist");
%>
<body>
<form action="netServlet" method="post">
    <a href="main.jsp">回主界面</a>
    <table border="0" align="center">
        <tr><td><a href="netServlet?name=creatact">创建新的志愿者活动</a></td></tr>
    </table>
    <br>
    <h3 align="center" style="color: brown">志愿者活动一览</h3>
    <table border="1" align="center">
        <thead><tr><th>账号名</th><th>活动号</th><th style="width: 100px">活动名</th><th>活动类别</th>
            <th style="width: 80px">活动地点</th><th style="width: 100px">活动开始时间</th><th style="width: 100px">活动结束时间</th>
            <th style="width: 100px">招募开始时间</th><th style="width: 100px">招募结束时间</th><th>活动持续时间</th><th>所需人数</th>
            <th style="width: 200px">活动描述</th><th>操作</th></tr>
        </thead>
        <tbody>
        <%
            if(passalist!=null){
                for(Activity a:passalist){
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
                    out.println("<td><a href='netServlet?name=join&jaid="+a.getActID()+"'>参加活动</a></td>");
                    out.println("</tr>");
                }
            }
        %>
        </tbody>
    </table>
</form>
</body>
</html>
