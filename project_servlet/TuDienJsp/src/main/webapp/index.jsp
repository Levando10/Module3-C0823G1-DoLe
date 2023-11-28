<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<h2>Vietnamese Dictionary</h2>

<form style="border: 4px solid black;display: inline-block;padding: 10px"  action="direction.jsp" method="get">
    <label for="eng"> Nhập từ cần tìm : </label>
    <input id = "eng" type="text" name = "enlang" placeholder="Nhập từ cần dịch">
    <br>
    <input type="submit">

</form>

</body>
</html>