<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create new Product</title>
  <style>
    .message{
      color:green;
    }
  </style>
</head>
<body>
<h1>Create new Product</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/product-controller">Back to Product list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Id Product: </td>
        <td><input type="text" name="id" id="id" required></td>
      </tr>
      <tr>
        <td>Name Product: </td>
        <td><input type="text" name="name" id="name" required></td>
      </tr>
      <tr>
        <td>Price Product: </td>
        <td><input type="number" name="price" id="price" required></td>
      </tr>
      <tr>
        <td>Description Product: </td>
        <td><input type="text" name="description" id="description" required></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create customer"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>