<%@ page import="dao.PostDao" %>
<%@ page import="entity.Post" %>
<%@ page import="dao.ReplyDao" %>
<%@ page import="entity.Reply" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.CustomerDao" %>
<%@ page import="entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/28
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title></title>
    <%
        String tid=(String) request.getSession().getAttribute("tid");
        int t=Integer.parseInt(tid);

        PostDao pd=new PostDao();
        Post p=pd.queryPostByTID(t);
        pageContext.setAttribute("p",p);

        ReplyDao rd=new ReplyDao();
        ArrayList<Reply> rlist=rd.queryReply(t);

        CustomerDao cd=new CustomerDao();
        String cn=null;
        String cid=(String) request.getSession().getAttribute("cid");
        String aid=(String) request.getSession().getAttribute("aid");
        if(cid!=null){
            Customer c=cd.queryCustomerByCID(cid);
            cn=c.getCname();
        }
        else{
            if(aid!=null){
                cn="管理员"+aid;
            }
            else{
                cn="游客";
            }
        }
        request.setAttribute("cn",cn);
    %>
</head>
<script>
    var errorr='<%=request.getParameter("ra")%>';
    if(errorr=="p")
        alert("用户信息未通过审核！请之后重试！")

</script>
<body>
    <form method="post" action="postServlet">
        <input type="hidden" name="name" value="reply">
        <input type="hidden" name="tid" value="<%=tid%>">
        <table width="60%" border="0" class="hovertable" align="center">
            <%out.print("<td><a href='main.jsp'>回主界面</a></td>");%>
        </table>
        <table width="60%" border="1" class="hovertable" align="center">
            <td style="text-align: center;width:100px;">${p.title}</td>
        </table>
        <table width="60%" border="1" class="hovertable" align="center">
            <tr>
                <td style="width: 70px;height: 100px;">${p.cname}</td>
                <td>${p.tText}</td>
            </tr>
        </table>
        <h3 align="center" style="color: skyblue">留言</h3>
        <table width="60%" border="1" class="hovertable" align="center">
            <%
                for(Reply r:rlist){

                    out.println("<tr>");
                    out.print("<td><a href='postServlet?name=deleter&rid="+r.getRid()+"&cidR="+r.getCid()+"'>删除留言</a></td>");
                    out.println("<td>"+r.getCname()+"</td>");
                    out.println("<td>"+r.getRep()+"</td>");
                    out.print("</tr>");
                }
            %>
        </table>
        <h3 align="center" style="color: skyblue">你的留言</h3>
        <table width="60%" border="1" class="hovertable" align="center">
            <input type="hidden" name="tid" value="<%=tid%>">
            <tr>
                <td>昵称</td>
                <td><input type="text" name="cn" value="<%=cn%>"></td>
            </tr>
            <tr>
                <td>请输入你的答复</td>
                <td><textarea rows="10" cols="60" name="rep"></textarea></td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
        </table>

    </form>
</body>
</html>
