<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %></h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>

<h1>Simple Calculator</h1>

<form style="margin-left: 30px;border: 2px black solid;display: inline-block" method="get" action="calculator-servlet">
  <label for="first">First  : <input id="first" type="number" name="firstNum"  required></label>
  <br>
  <select name="cal" >
    <option value="+">Add</option>
    <option value="-">Sub</option>
    <option value="*">Mult</option>
    <option value="/">Dvi</option>
  </select>
  <br>
  <label for="second">Second  : <input id="second" type="number" name="secondNum"  required></label>
  <br>
  <p>Result = ${result}</p>
  <input type="submit">
</form>
</body>
</html>