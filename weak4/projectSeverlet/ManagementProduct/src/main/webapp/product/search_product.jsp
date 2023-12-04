<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/3/2023
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a style="text-align: center;text-decoration: none" href="/product-controller">Back to Product list</a>
</p>
<h1>List Search Product</h1>
<table border="1">
    <tr><th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${requestScope['productList']}" var="listProduct">
        <tr>
            <td>${listProduct.getId()}</td>
            <td>${listProduct.getNameProduct()}</td>
            <td>${listProduct.getPrice()}</td>
            <td>${listProduct.getDescription()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
