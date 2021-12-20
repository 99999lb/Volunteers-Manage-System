<%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/19
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<script>
    var aRep='<%=request.getParameter("aRep")%>'
    if(aRep=="true")
        alert("报名成功");
</script>
<body>
</body>
</html>
