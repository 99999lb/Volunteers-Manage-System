<%@ page import="dao.CustomerDao" %>
<%@ page import="entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/13
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>
        <%
            String id= (String) request.getSession().getAttribute("cid");
            out.print(""+id);
        %>
        个人信息
    </title>
    <link rel="stylesheet" href="css/nav.css">
</head>
<script>
    var upd='<%=request.getParameter("upd")%>'
    if(upd=="true")
        alert("信息更新成功！请等待审核！")
    else if(upd=="update")
        alert("请更新信息！")

</script>
<body>
<ul>
    <li><a href="main.jsp">主页</a></li>
    <li><a href="netServlet?name=acts">志愿活动</a></li>
    <li><a href="netServlet?name=news">新闻报道</a></li>
    <li><a href="netServlet?name=forum">志愿者论坛</a></li>
    <li><a href="netServlet?name=pac">志愿者培训</a></li>
    <li><a href="netServlet?name=download">文件下载</a></li>
    <li><%
        String cid= (String) request.getSession().getAttribute("cid");
        String aid= (String) request.getSession().getAttribute("aid");
        if(cid==null && aid==null)
            out.println("<a href='Login.jsp'>登录</a>");
        else if(cid!=null)
            out.println("<a href='customer.jsp'>用户中心"+cid+"</a>");
        else if(aid!=null)
            out.println("<a href='admin.jsp'>管理员中心"+aid+"</a>");
    %></li>
</ul>
<div style="margin-left:25%;padding:1px 16px;height:1000px;">
    <%
        if(cid!=null){
            CustomerDao dao=new CustomerDao();
            Customer c=dao.queryCustomerByID(cid);
            String pass=null;
            String s=c.getCsort().trim();
            String sort=dao.checkSort(s);
            if(c.getCname()==null||c.getSex()==null||c.getSig()==null||c.getPhone()==null||c.getAddress()==null){
                pass="检测到初始状态，请完善信息";
            }
            else{
                String p=c.getPass().trim();
                pass=dao.checkPass(p);
            }
            pageContext.setAttribute("cus",c);
            pageContext.setAttribute("pass",pass);
            pageContext.setAttribute("sort",sort);
            request.getSession().setAttribute("pass",c.getPass());
            request.getSession().setAttribute("sort",c.getCsort());
        }
    %>
    <form method="post" action="servelt">
        <input type="hidden" name="name" value="cinfo">
        <a href="main.jsp">回主界面</a>
        <table border="0" align="center">
            <tr><td style="width: 350px;height: 80px">
                <%
                    String s= (String) request.getSession().getAttribute("sort");
                    if(s.trim().equals("C"))
                        out.println("<h1 style='color: sandybrown;' align='center'>团队志愿者用户主页</h1>");
                    else
                        out.println("<h1 style='color: powderblue;' align='center'>个人志愿者用户主页</h1>");
                %>
            </td></tr>
        </table>
        <table border="0" align="center">
            <tr>
                <td>id</td>
                <td style="border-style: none none none none"><input type="text" name="cid" value="${cus.cid}" readonly="readonly" style="border:0px;background-color:#f3faff"></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="cname" value="${cus.cname}" style="border:0px;background-color:#ffffff"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" value="${cus.sex}" readonly="readonly" style="border:0px;background-color:#f3faff"></td>
            </tr>
            <tr>
                <td>签名</td>
                <td><input type="text" name="sig" value="${cus.sig}" style="width: 300px;height: 50px;border:0px;background-color:#ffffff" readonly="readonly"></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input type="text" name="phone" value="${cus.phone}" readonly="readonly" style="border:0px;background-color:#f3faff"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address" value="${cus.address}" style="width: 300px;height: 50px;border:0px;background-color:#ffffff" readonly="readonly" style="border:0px;"></td>
            </tr>
            <tr>
                <td>志愿者类别</td>
                <td><input type="text" name="csort" value="${sort}" readonly="readonly" style="border:0px;background-color:#f3faff"></td>
            </tr>
            <tr>
                <td>个人信息状态</td><td><input type="text" name="pass" style="width: 300px;height: 50px;border:0px;background-color:#ffffff" value="${pass}" readonly="readonly"><a href="servelt?name=updatecinfo">修改个人信息</a></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <%
                        if(s.trim().equals("C"))
                            out.println("<a href='servelt?name=cacts'>创建的活动</a>");
                        else
                            out.println("<a href='servelt?name=joinacts'>参与的活动</a>");
                    %>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href='postServlet?name=dPost'>发布的帖子</a>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><a href="servelt?name=returnlogin">退出登录</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
