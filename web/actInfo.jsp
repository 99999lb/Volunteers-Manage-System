<%@ page import="entity.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Activity" %>
<%@ page import="dao.ActivityDao" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/18
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活动信息</title>
    <%
        String id= (String) request.getSession().getAttribute("actID");
        ActivityDao ad=new ActivityDao();
        ArrayList<Activity> alist=ad.queryActivityByPass();
    %>
</head>
<script>
    var aRep='<%=request.getParameter("aRep")%>'
    if(aRep=="false")
        alert("报名人数已满！")
</script>
<body>
<form name="vact" method="post" action="servlet">
    <table border="1" align="center">
        <thead><tr><th>活动号</th><th style="width:200px">活动名</th><th>类别</th><th>地点</th>
            <th>活动开始时间</th><th>活动结束时间</th><th>招募开始时间</th><th>招募结束时间</th>
            <th>持续时间</th><th>需求人数</th><th>活动描述</th></tr>
        </thead>
        <tbody>
            <%
                for(Activity a:alist){
                    out.println("<tr>");
                    out.println("<td>"+a.getActID()+"</td>");
                    out.println("<td>"+a.getActName()+"</td>");
                    out.println("<td>"+a.getSort()+"</td>");
                    out.println("<td>"+a.getPlace()+"</td>");
                    out.println("<td>"+a.getrStartTime()+"</td>");
                    out.println("<td>"+a.getEndTime()+"</td>");
                    out.println("<td>"+a.getrStartTime()+"</td>");
                    out.println("<td>"+a.getrEndTime()+"</td>");
                    out.println("<td>"+a.getDuration()+"</td>");
                    out.println("<td>"+a.getPeoNum()+"</td>");
                    out.println("<td>"+a.getActBrif()+"</td>");
                    out.println("<td><a href='sign.jsp'>报名</a>");
                    out.println("</tr>");
                }
            %>
        </tbody>
    </table>
</form>
</body>
</html>
