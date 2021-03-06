
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.JoinActs" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/20
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%--普通用户的已参加活动--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <link rel="stylesheet" href="css/basictable.css">
    <title>已参与活动</title>
    <%
        ArrayList<JoinActs> list= (ArrayList<JoinActs>) request.getSession().getAttribute("joinbyid");
    %>
</head>
<script>
    var err='<%=request.getParameter("pa")%>'
    if(err=="y")
        alert("活动评分成功！")
    else if(err=="n")
        alert("活动评分失败！请稍后再试！")

</script>
<body>
<a href="customer.jsp">回个人主页</a>
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
                Float p= Float.valueOf(a.getApoint());
                if(p==0){
                    switch (flag.trim()){
                        case "Y":
                            out.println("<td><a href='servelt?name=point&ptaid="+a.getActID()+"'>评分</a></td>");
                            break;
                        case "N":
                            out.println("<td>评分未开放</td>");
                            break;
                    }
                }
                else
                    out.println("<td>评分完成</td>");
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
</form>
</body>
</html>
