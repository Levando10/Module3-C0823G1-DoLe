<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/28/2023
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    div{
      background-color: red;
      width: 100%;
      height: 30px;
      position: fixed;
      text-align: center;
    }
  </style>
</head>

<body>
<div>
  Hello Anh Em
</div>
<h1> Hello Admin</h1>

<%
  String username = request.getParameter("user");
  Date loginTime = (Date) request.getAttribute("loginTime");
%>
<h3>Hí <%=username %></h3>
<h3>Login time :  <%=loginTime %></h3>
</body>
</html>
