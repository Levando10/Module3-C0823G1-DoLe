<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/5/2023
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <!-- Font Awesome -->

    <style>
      * {
        padding: 0;
        margin: 0;
        border: 0;
        box-sizing: border-box;
      }

      .quantity-controls {
        display: flex;
        align-items: center;
      }

      .quantity-controls input {
        width: 3em;
        text-align: center;
        margin: 0 1.5em;
      }
    </style>
</head>
<body>
<!-- Navbar -->
<nav style="padding: 0;" class="navbar navbar-expand-sm navbar-light bg-body-tertiary">
    <!-- Container wrapper -->
    <div class="container-fluid bg-dark">
        <!-- Navbar brand -->
        <a class="navbar-brand me-2" target="_blank" href="https://www.facebook.com/dolevan1011">
            <img

                    height="60"
                    width="160"
                    alt="MDB Logo"
                    loading="lazy"
                    style="margin-top: -1px;"
            />
        </a>
    </div>

</nav>
<!-- Navbar -->


<div class="container-fluid">
    <div style="display: flex;justify-content: center;align-items: center;">
        <h1 style="font-size: 40px;padding: 10px;font-family: 'Kanit', sans-serif;font-weight: bold;">
            Chọn dịch vụ</h1>
    </div>


    <div class="row">

        <table class="table table-hover  table-striped">
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="/may-dang-thue-servlet" class="btn btn-primary">Back</a></td>
            </tr>
            <tr class="bg-success">
                <th>#</th>
                <th>Tên dịch vụ</th>
                <th>Số Lượng</th>
                <th>Giá bán</th>
            </tr>

            <c:forEach items="${dichVuList}" var="item" varStatus="loop">

                <tr>
                    <td>${loop.count}</td>
                    <td>${item.tenDichVuDiKem}</td>
                    <td class="quantity-controls">
                        <input class="btn btn-danger" type="button" value="-"
                               onclick="adjustQuantity(${loop.count}, -1)">
                        <p id="quantity_${loop.count}">0</p>
                        <input class="btn btn-primary" type="button" value="+"
                               onclick="adjustQuantity(${loop.count}, 1)">
                    </td>
                    <td>${item.giaDichVuDiKem} Vnd</td>
                </tr>
            </c:forEach>


        </table>
    </div>

    </table>

</div>
</div>

<!-- End row full -->
</div>


</div>
<!-- End container -->
<br><br><br>
<!-- Start Footer -->
<footer id="sticky-footer" class="flex-shrink-0 py-3 bg-dark text-white-50 fs-3 mt-4 fixed-bottom">
    <div class="container text-center">
        <small>Copyright &copy; Net Cỏ</small>
    </div>
</footer>


<script>

  function adjustQuantity(productId, adjustment) {
    var quantityElement = document.getElementById("quantity_" + productId);

    var currentQuantity = parseInt(quantityElement.innerText);

    var newQuantity = currentQuantity + adjustment;

    if (newQuantity >= 0) {
      quantityElement.innerText = newQuantity;
    }
  }

</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>

</body>
</html>