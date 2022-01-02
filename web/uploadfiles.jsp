<%--
  Created by IntelliJ IDEA.
  User: 27721
  Date: 2021/12/31
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
            <a href="admin.jsp">回个人主页</a>
    <p align="center">上传文件选择</p>
    <form method="post" action="upload" ENCTYPE="multipart/form-data">
        <input type="hidden" name="opttype" value="fileupload">
        <table width="75%" border="1" align="center">
            <tr>
                <td>
                    <div align="center">
                        1、<input type="FILE" name="FILE1" size="30">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        2、<input type="FILE" name="FILE2" size="30">
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" height="40">
                    <input type="submit" name="submit" value="上传">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
