<%@ page import="dao.ActivityDao" %>
<%@ page import="entity.ActMes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Acts" %><%--
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
        String id= (String) request.getSession().getAttribute("cid");
        ActivityDao ad=new ActivityDao();
        ArrayList<Acts> alist=ad.queryActs();
        pageContext.setAttribute("ad",ad);
    %>
</head>
<body>
<form name="fact" method="post" action="servelt">
    <table border="1" align="center">
        <thead><tr><th>活动号</th><th>活动名</th><th>完成状况</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Acts a:alist){
                String p=a.getYON().trim();
                String yon=ad.checkYON(p);
                out.println("<tr>");
                out.println("<td>"+a.getActID()+"</td>");
                out.println("<td>"+a.getActName()+"</td>");
                out.println("<td>"+yon+"</td>");
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
</form>
</body>
</html>
