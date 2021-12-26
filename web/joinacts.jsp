<%@ page import="dao.ActivityDao" %>
<%@ page import="entity.ActMes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.JoinActs" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/20
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已完成活动</title>
    <%
        ArrayList<JoinActs> list= (ArrayList<JoinActs>) request.getSession().getAttribute("joinbyid");
    %>
</head>
<body>
<form name="fact" method="post" action="servelt">
    <table border="1" align="center">
        <thead><tr><th>活动号</th><th>活动名</th><th>活动类别</th><th>活动地点</th>
            <th>活动开始时间</th><th>活动结束时间</th><th>完成状况</th><th>评分</th><th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(JoinActs a:list){
                out.println("<tr>");
                out.println("<td>"+a.getActID()+"</td>");
                out.println("<td>"+a.getActname()+"</td>");
                out.println("<td>"+a.getSort()+"</td>");
                out.println("<td>"+a.getPlace()+"</td>");
                out.println("<td>"+a.getSt()+"</td>");
                out.println("<td>"+a.getEt()+"</td>");
                String flag=a.getFin();
                switch (flag.trim()){
                    case "Y":
                        out.println("<td>活动完成</td>");
                        break;
                    case "N":
                        out.println("<td>活动未完成</td>");
                        break;
                }
                out.println("<td>"+a.getApoint()+"</td>");
                switch (flag.trim()){
                    case "Y":
                        out.println("<td><a href='servelt?name=point&ptaid="+a.getActID()+"'>评分</a></td>");
                        break;
                    case "N":
                        out.println("<td>评分未开放</td>");
                        break;
                }
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
</form>
</body>
</html>
