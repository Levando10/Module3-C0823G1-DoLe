<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/28/2023
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String,String> map = new HashMap<>();
    map.put("book","sách");
    map.put("Banana","Chuối");
    map.put("Phone","Điện thoại");
    map.put("Apple","Trái táo");
    map.put("Lemon","Chanh");
    map.put("Money","Tiền");

    String englishDirection = request.getParameter("enlang");
    String result  = map.get(englishDirection);
    if (result == null) {
        result = "Không tìm thấy từ!!!";
    }

%>
<h1> Từ vựng <%= englishDirection %>  </h1>
<h1>Kết quả :  <%= result %> </h1>

</body>
</html>
