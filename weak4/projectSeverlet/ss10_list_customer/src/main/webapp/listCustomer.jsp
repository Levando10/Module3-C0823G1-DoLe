<%@ page import="java.util.List" %>
<%@ page import="com.example.ss10_list_customer.model.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/1/2023
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center;color: red">Danh sách nhân viên</h1>
<table style="text-align: center;margin-left: 30%" border="1" width="35%" height = "30%" >


<tr>
    <th>Stt</th>
    <th>Tên</th>
    <th>Ngày Sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
</tr>
    <c:forEach var="customer" items="${requestScope.customerList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getBirth()}</td>
            <td>${customer.getAddress()}</td>
            <td><img src="${customer.getImage()}" width="80px" height="80px"></td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
