<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/2/2023
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="margin-left: 30px">List Product!!!</h1>

<c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
</c:if>

<form  method="get" action="/search-product-servlet">
    <label for="search_product">Tìm kiếm sản phẩm <input id="search_product" type="text"  name="search" placeholder="Name Product"></label>
   <input type="submit" value="Search">
</form>

<table border="1">
    <tr><th>Stt</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Update</th>
        <th>Delete</th>
        <th>Thông tin</th>
    </tr>
    <c:forEach items="${requestScope['productList']}" var="listProduct" varStatus="loop">
    <tr>
        <td>${loop.count}</td>
        <td>${listProduct.getNameProduct()}</td>
        <td>${listProduct.getPrice()}</td>
        <td>${listProduct.getDescription()}</td>
        <td><a href="/product-controller?action=update&id=${listProduct.getId()}">Update</a></td>
        <td><a href="/product-controller?action=delete&id=${listProduct.getId()}">Delete</a></td>
        <td><a href="/product-controller?action=view&id=${listProduct.getId()}">View</a></td>
    </tr>
    </c:forEach>

    <tr>
        <td colspan="7"><a href="/product-controller?action=create">Add Product</a></td>
    </tr>
</table>

</body>
</html>
