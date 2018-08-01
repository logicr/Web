<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 2018/7/31
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.*" %>

<%--<html>--%>
<%--<head>--%>
    <%--<title>request内置对象</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>request内置对象</h1>--%>
<%--用户名：<%=request.getParameter("userName")%>--%>
<%--爱好：<%--%>
    <%--String[] skills = request.getParameterValues("skill") ;--%>
    <%--for(String s:skills){--%>
        <%--out.println(s+"&nbsp;&nbsp;");--%>
    <%--}--%>
<%--%>--%>
<%--<hr>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
    <title>request内置对象</title>
</head>
<body>
<h1>request内置对象</h1>
<%
    // 解决中文乱码问题,注意此字符集需要和提交页面字符集保持一致
    request.setCharacterEncoding("UTF-8");
// 使用setAttribute设置属性
    request.setAttribute("password","test");
%>
用户名：<%=request.getParameter("userName")%>
爱好：<%
    String[] skills = request.getParameterValues("skill") ;
    for(String s:skills){
        out.println(s+"&nbsp;&nbsp;");
    }
%> <br>
密码：<%=request.getParameter("password")%>
<hr>
</body>
</html>