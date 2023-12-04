<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Deleting Product</title>
</head>
<body>
<h1>Delete Product</h1>
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
      <tr>
        <td><input type="submit" value="Delete Product"></td>
      </tr>
    </table>
  </fieldset>
</body>
</html>