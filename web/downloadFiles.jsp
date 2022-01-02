<%@ page import="dao.PostDao" %>
<%@ page import="entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.FileDao" %>
<%@ page import="entity.FileStore" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2022/1/1
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<html>
<head>
    <title></title>
    <%
        FileDao fd=new FileDao();
        List<FileStore> flist=fd.queryFile();
        request.setAttribute("flist",flist);
    %>
</head>
<body>
    <a href="main.jsp">»ØÖ÷Ò³</a>
    <form method="post" action="netServlet">
        <input type="hidden" name="name" value="download">
        <table width="75%" border="1" align="center">
            <%
                for(FileStore f:flist){
                    out.println("<tr>");
                    out.print("<td><a href='download?fname="+f.getNewFileName()+"&fsort="+f.getSort()+"'>"+f.getFileName()+"</a></td>");
                    out.print("</tr>");
                }
            %>

        </table>
    </form>
</body>
</html>
