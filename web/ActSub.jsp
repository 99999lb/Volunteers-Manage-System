<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Kuroen
  Date: 2021/12/13
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%--团队用户发布活动填写信息--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/table-style.css">
    <title>发布活动</title>
    <script>
        var err='<%=request.getParameter("ec")%>';
        if(err=="err")
            alert("活动创建失败！请检查后重试！")

    </script>
</head>
<body>
<a href="acts.jsp">回上一页</a>
<form action="netServlet" method="post">
    <input type="hidden" name="name" value="subact">
    <table border="1" align="center">
        <tr><td style="width: 350px;height: 80px"><h1 style="color: lightgray;" align="center">发布志愿者活动</h1></td></tr>
    </table>
    <br><br>
    <table border="0" align="center">
        <tr><td>发起人账号：</td><td><input type="text" name="actcid" value="${cid}" readonly="readonly"></td></tr>
        <tr><td>活动号：</td><td><input type="text" name="actid" maxlength="10" readonly="readonly" value=<%
            String num="";
            for(int i=0;i<10;i++)
                num+=new Random().nextInt(10);
            out.println(num);
        %>>
        </td></tr>
        <tr><td>活动名：</td><td><input type="text" name="actn" style="width: 200px"></td></tr>
        <tr><td>活动类别：</td><td><select size="1" name="as">
            <option>探访老人</option>
            <option>清洁公共卫生</option>
            <option>公益表演</option>
            <option>公益宣传</option>
            <option>公益募捐</option>
            <option>应急救援</option>
            <option>社区服务</option>
            <option>协助交通</option>
        </select> </td></tr>
        <tr><td>活动地点：</td><td><input type="text" name="p" style="width: 300px;height: 50px"></td></tr>
        <tr><td>活动开始时间：</td><td><input type="datetime-local" name="st"></td></tr>
        <tr><td>活动截止时间：</td><td><input type="datetime-local" name="et"></td></tr>
        <tr><td>招募开始时间：</td><td><input type="datetime-local" name="srt"></td></tr>
        <tr><td>招募截止时间：</td><td><input type="datetime-local" name="ert"></td></tr>
        <tr><td>活动持续时间（/h）：</td><td><input type="number" name="dur" min="0.5" step="0.5">*持续时间不得小于0.5h</td></tr>
        <tr><td>活动需求人数：</td><td><input type="number" name="pnum" min="5">*所需人数不得小于5</td></tr>
        <tr><td>活动描述：</td><td><input type="text" name="abrif" style="width: 300px;height: 100px"></td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
