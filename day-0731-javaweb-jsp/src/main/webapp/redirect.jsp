<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 2018/7/31
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>redirect1</title>
</head>
<body>
<h1>hello 1</h1>
<%
    response.sendRedirect("toredirect.jsp");
%>
</body>
</html>
