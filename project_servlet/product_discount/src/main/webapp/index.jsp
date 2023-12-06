
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Currency Converter</title>

</head>
<body>
<h2>Currency Converter</h2>

<form action="/handle-discount" method="post">
  <input type="text" name="productDescription" placeholder="Sản phẩm" /><br/>
  <input type="text" name="price" placeholder="Giá niêm yết của sản phẩm" value="0"/><br/>
  <input type="text" name="percent" placeholder="Tỷ lệ chiết khấu (phần trăm)" value="0"/><br/>
  <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>