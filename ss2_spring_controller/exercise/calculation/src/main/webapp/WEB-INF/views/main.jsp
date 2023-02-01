
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/1/2023
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<br>
<form action="/calculator" method="post">
    <input name="num1" placeholder="number 1">
    <select name="math">
        <option value="addition">Addition (+)</option>
        <option value="subtraction">Subtractin (-)</option>
        <option value="multiplication">Multiplication (x)</option>
        <option value="division">Division (/)</option>
    </select>
    <input name="num2" placeholder="number 2">
    <br>
    <br>
    <button type="submit">Enter</button>
</form>
<h1>Result : ${result}</h1>
</body>
</html>