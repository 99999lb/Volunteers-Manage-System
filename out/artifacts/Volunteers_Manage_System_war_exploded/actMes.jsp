<%@ page import="entity.Activity" %>
<%@ page import="dao.ActivityDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.ActMes" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/20
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参与的活动</title>
    <%
        String id= (String) request.getSession().getAttribute("cid");
        ActivityDao ad=new ActivityDao();
        ArrayList<ActMes> alist=ad.queryActMes(id);
    %>
</head>
<body>
<form name="vactmes" method="post" action="servelt">
    <table border="1" align="center">
        <thead><tr><th>活动号</th><th>活动名</th><th>开始时间</th>
            <th>结束时间</th><th>活动评分</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(ActMes a:alist){
                out.println("<tr>");
                out.println("<td>"+a.getActID()+"</td>");
                out.println("<td>"+a.getActName()+"</td>");
                out.println("<td>"+a.getStartTime()+"</td>");
                out.println("<td>"+a.getEndTime()+"</td>");
                out.println("<td>"+a.getPoint()+"</td>");
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
</form>
</body>
</html>
