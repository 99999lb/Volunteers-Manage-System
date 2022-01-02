<%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2022/1/1
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/nav.css">
</head>
<body>
<ul>
    <li><a class="active" href="#home">Home</a></li>
    <li><a href="#news">News</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#about">About</a></li>
</ul>
<div style="margin-left:25%;padding:1px 16px;height:1000px;">
    <h1>全高的固定侧导航栏</h1>
    <h2>请尝试滚动此区域，并查看 sidenav 如何粘在页面上。</h2>
    <p>请注意，此 div 元素的左外边距为 25％。这是因为侧导航栏被设置为 25％ 宽。如果删除这个外边距，则 sidenav 将叠加到该 div 上。</p>
    <p>还要注意，我们已为 sidenav 设置 overflow：auto。如果 sidenav 太长时（例如，如果其中有超过 50 个链接），会添加滚动条。</p>
    <p>Some text..</p>
    <p>Some text..</p>
    <p>Some text..</p>
    <p>Some text..</p>
    <p>Some text..</p>
    <p>Some text..</p>
    <p>Some text..</p>
</div>
</body>
</html>
