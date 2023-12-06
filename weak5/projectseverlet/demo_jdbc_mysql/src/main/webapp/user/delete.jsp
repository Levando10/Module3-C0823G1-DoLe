<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/4/2023
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting User</title>
</head>
<body>
<h1>Delete User</h1>

<p>
    <a href="/users">Back to Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td>${requestScope["user"].id}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["user"].name}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["user"].email}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete User"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
