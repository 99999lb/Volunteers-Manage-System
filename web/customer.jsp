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
    <title>
        <%
            String id= (String) request.getSession().getAttribute("cid");
            out.print(""+id);
        %>
        个人信息
    </title>
</head>
<script>
    var upd='<%=request.getParameter("upd")%>'
    if(upd=="true")
        alert("信息更新成功！请等待审核！")
    else if(upd=="update")
        alert("请更新信息！")

</script>
<body>
    <%
        String cid= (String) request.getSession().getAttribute("cid");//此时用户名已经存储在了session中，在需要用户名的时候使用这句话
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
        <table border="1" align="center">
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
                <td><input type="text" name="cid" value="${cus.cid}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="cname" value="${cus.cname}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" value="${cus.sex}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>签名</td>
                <td><input type="text" name="sig" value="${cus.sig}" style="width: 300px;height: 50px" readonly="readonly"></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input type="text" name="phone" value="${cus.phone}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address" value="${cus.address}" style="width: 300px;height: 50px" readonly="readonly"></td>
            </tr>
            <tr>
                <td>志愿者类别</td>
                <td><input type="text" name="csort" value="${sort}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>个人信息状态</td><td><input type="text" name="pass" style="width: 300px;height: 50px" value="${pass}" readonly="readonly"><a href="servelt?name=updatecinfo">修改个人信息</a></td>
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
</body>
</html>
