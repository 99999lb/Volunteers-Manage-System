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
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>�ļ�����</title>
    <link rel="stylesheet" href="css/nav.css">
    <%
        FileDao fd=new FileDao();
        List<FileStore> flist=fd.queryFile();
        request.setAttribute("flist",flist);
    %>
</head>
<body>
<ul>
    <li><a href="main.jsp">��ҳ</a></li>
    <li><a href="netServlet?name=acts">־Ը�</a></li>
    <li><a href="netServlet?name=news">���ű���</a></li>
    <li><a href="netServlet?name=forum">־Ը����̳</a></li>
    <li><a href="netServlet?name=pac">־Ը����ѵ</a></li>
    <li><a href="netServlet?name=download">�ļ�����</a></li>
    <li><%
        String cid= (String) request.getSession().getAttribute("cid");
        String aid= (String) request.getSession().getAttribute("aid");
        if(cid==null && aid==null)
            out.println("<a href='Login.jsp'>��¼</a>");
        else if(cid!=null)
            out.println("<a href='customer.jsp'>�û�����"+cid+"</a>");
        else if(aid!=null)
            out.println("<a href='admin.jsp'>����Ա����"+aid+"</a>");
    %></li>
</ul>
<div style="margin-left:10%;padding:1px 16px;height:1000px;">
    <h1>�ļ�����</h1>
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
</div>
</body>
</html>
