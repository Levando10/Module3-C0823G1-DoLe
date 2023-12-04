<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/2/2023
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Product</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a style="text-align: center;text-decoration: none" href="/product-controller">Back to Product list</a>
</p>

<form method="post">
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="name" id="name" value="${requestScope["product"].getNameProduct()}"></td>
      </tr>
      <tr>
        <td>Price: </td>
        <td><input type="number" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
      </tr>
      <tr>
        <td>Description: </td>
        <td><input  type="text" name="description" id="description" value="${requestScope["product"].getDescription()}"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Update Product"></td>
      </tr>
    </table>
  </fieldset>
</form>

</body>
</html>
