<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <p>
    <c:if test='${requestScope["message"] != null}'>
      <span class="message">${requestScope["message"]}</span>
    </c:if>
  </p>

</center>
<div>
  <form style="margin-left: 40%" method="get" action="/users">
    <input type="hidden" name="action" value="search">
    <label>Tìm theo quốc gia : <input type="text" name="search_name" placeholder="Nhập quốc gia"> </label>
    <input type="submit" value="search">
  </form>
  <a style="text-decoration: none;margin-left: 40%" href="/users?action=sort">Sort by name</a>
</div>

<div class="container">
  <table class="table table-hover">
    <tr><th>Stt</th>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th>Actions</th>
    </tr>

    <c:forEach var="user" items="${listUser}" varStatus="loop">
      <tr>
        <td><c:out value="${loop.count  }"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
        <td>
          <a class="btn btn-primary" href="/users?action=edit&id=${user.id}">Edit</a>
         <a  class="btn btn-primary" onclick="showMessage('${user.id}','${user.name}')">Xóa sản phẩm</a>
      </tr>
    </c:forEach>
    <tr><td colspan="5"> <a href="/users?action=create">Add New User</a></td></tr>
  </table>
</div>

</body>
<script>
  function showMessage(id,name) {
    console.log(id)
    console.log("hello")
    let option = confirm('Are you sure to delete ?\n' +
            'Id : ' + id + '\n Name :' + name
    );
    if (option === true) {
      window.location.href = "/users?action=delete&id=" + id;
    }
  }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>