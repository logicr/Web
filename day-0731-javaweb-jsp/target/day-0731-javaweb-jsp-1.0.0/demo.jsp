<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 2018/7/31
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>
</head>
<body>
<h1>user login</h1>
<hr>
<form action="dologin.jsp" name="loginFrom" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>掌握语言</td>
            <td>
                <input type="checkbox" name="skill" value="C语言">C语言
                <input type="checkbox" name="skill" value="Java">Java
                <input type="checkbox" name="skill" value="C++">C++
                <input type="checkbox" name="skill" value="Python">Python
            </td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="登录"></td>
        </tr>
    </table>

</form>
</body>
</html>
