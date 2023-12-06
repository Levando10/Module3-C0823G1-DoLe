<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/4/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Tên sản phẩm :${name}</h3>
<h3>Giá sản phẩm :${price}</h3>
<h3>Sản phẩm sau khi chiết khấu :${price + discountAmount}</h3>

</body>
</html>
