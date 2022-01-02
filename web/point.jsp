<%@ page import="entity.JoinActs" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/28
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>Title</title>
    <%
        ArrayList<JoinActs> list= (ArrayList<JoinActs>) request.getSession().getAttribute("pointact");
        request.getSession().setAttribute("ptaid",list.get(0).getActID());
    %>
</head>
<body>
<a href="customer.jsp">回个人主页</a>
<form name="fact" method="post" action="servelt">
    <input type="hidden" name="name" value="pa">
    <table border="0" align="center">
        <tbody>
        <%
            for(JoinActs a:list){
                out.println("<tr><td>活动号："+a.getActID()+"</td><td>活动名："+a.getActname()+"</td></tr>");
                out.println("<tr><td>活动类别："+a.getSort()+"</td>");
                out.println("<td>活动地点："+a.getPlace()+"</td></tr>");
                out.println("<tr><td>活动开始时间："+a.getSt()+"</td></tr><tr><td>活动结束时间："+a.getEt()+"</td></tr>");
            }
        %>
        <tr><td colspan="2" align="center">评分：<input type="number" style="width: 200px" step="0.5" max="5" min="0.5" name="pointact"></td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
        </tbody>
    </table>
</form>
</body>
</html>
