<%@ page import="dao.CustomerDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Customer" %><%--
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


            ArrayList<Customer> list= (ArrayList<Customer>) session.getAttribute("list");
        %>
    </title>
</head>
<body>

<form name="admin" method="post" action="servelt">
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
            if(list!=null){
                for(Customer c:list){
                    out.println("<tr>");
                    out.println("<td>"+c.getCid()+"</td>");
                    out.println("<td>"+c.getCname()+"</td>");
                    out.println("<td>"+c.getSex()+"</td>");
                    out.println("<td>"+c.getSig()+"</td>");
                    out.println("<td>"+c.getPhone()+"</td>");
                    out.println("<td>"+c.getAddress()+"</td>");
                    out.println("<td>"+c.getCsort()+"</td>");
                    out.println("<td><a href='servlet?name=checkpass'>审核通过</a></td>");
                    out.println("</tr>");
                }
            }
        %>
        </tbody>
    </table>
    <br>
    <h3 align="center" style="color: brown">待审核志愿者活动信息</h3>
    <table>
    </table>
    <br>
    <h3 align="center" style="color: lightgray">待审核帖子信息</h3>
    <table>
    </table>
</form>
</body>
</html>
