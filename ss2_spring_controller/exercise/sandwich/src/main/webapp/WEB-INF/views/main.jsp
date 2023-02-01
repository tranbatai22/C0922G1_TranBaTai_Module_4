<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/1/2023
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Spice Menu</h1>
<br>
<form action="/select" method="post">
    <input type="checkbox" name="spice" value="Lettuce">Lettuce
    <input type="checkbox" name="spice" value="Tomato">Tomato
    <input type="checkbox" name="spice" value="Mustard">Mustard
    <input type="checkbox" name="spice" value="Sprouts">Sprouts
    <button type="submit">Finish</button>
</form>

</body>
</html>