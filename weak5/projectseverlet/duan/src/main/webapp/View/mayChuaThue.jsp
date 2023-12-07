<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/5/2023
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  <script>

  </script>
</head>
<body>
<nav style="padding: 0;" class="navbar navbar-expand-sm navbar-light bg-body-tertiary">
  <!-- Container wrapper -->
  <div class="container-fluid bg-dark">
    <!-- Navbar brand -->
    <a class="navbar-brand me-2" target="_blank" href="https://www.facebook.com/dolevan1011">
      <img
              src="data:image/png;base64,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"
              height="0"
              width="160"
              alt="MDB Logo"
              loading="lazy"
              style="margin-top: -1px;"
      />
    </a>
  </div>

</nav>
<!-- Navbar -->
<br><br>
<div class="container-fluid">
  <p class="text-center fs-4 fw-bold">Quản lý máy chưa được thuê </p>
  <table class="table table-striped">
    <tr>
      <%--    <td> <a href="/may-tinh-servlet?action=dangthue"><button>Máy đang được thuê</button></a></td>--%>
      <td> <a class="btn btn-primary" href="/may-dang-thue-servlet?action=dangthue">Máy đang được thuê</a></td>
      <td> <a  class="btn btn-primary" href="/may-tinh-servlet">Home</a></td>
    </tr>
    <tr class="table-primary">
      <th>Tên máy</th>
      <th>Mở máy</th>

    </tr>
    <c:forEach items="${mayChuaThue}" var="mayTinh">

      <tr>
        <td><a href="/may-dang-thue-servlet?action=detail&id=${mayTinh.idMayTinh}">${mayTinh.tenMayTinh}</a></td>
        <td>  <a class="btn btn-primary"  href="/may-tinh-servlet?action=startTime&idMay=${mayTinh.idMayTinh}" >Mở Máy</a>
        </td>



      </tr>
    </c:forEach>
  </table>
</div>

<br> <br> <br>


<!-- Footer -->
<footer id="sticky-footer" class="flex-shrink-0 py-3 bg-dark text-white-50 fs-3 mt-4 fixed-bottom">
  <div class="container text-center">
    <small>Copyright &copy; Net Cỏ</small>
  </div>
</footer>
<script>

</script>

<script src="../ss9/bootstrap-5.2.3-dist/js/bootstrap.bundle.js"></script>
</body>
</html>