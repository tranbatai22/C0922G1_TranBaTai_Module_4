
<%--
  Created by IntelliJ IDEA.
  User: tranthingoclan
  Date: 14/12/2022
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="get">
    <input type="text" name="eng" placeholder="Input"><br><br>
    <button type="submit">Search</button><br>
    <h3>${result}</h3>
</form>
</body>
</html>