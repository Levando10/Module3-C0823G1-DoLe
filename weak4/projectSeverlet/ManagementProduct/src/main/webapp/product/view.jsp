<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
  <a href="/product-controller">Back to product list</a>
</p>
<table>
  <tr>
    <td>Id: </td>
    <td>${requestScope["product"].getId()}</td>
  </tr>
  <tr>
    <td>Name: </td>
    <td>${requestScope["product"].getNameProduct()}</td>
  </tr>
  <tr>
    <td>Price: </td>
    <td>${requestScope["product"].getPrice()}</td>
  </tr>
  <tr>
    <td>Description: </td>
    <td>${requestScope["product"].getDescription()}</td>
  </tr>
</table>
</body>
</html>