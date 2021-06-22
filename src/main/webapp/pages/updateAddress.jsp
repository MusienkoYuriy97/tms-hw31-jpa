<%--
  Created by IntelliJ IDEA.
  User: 97mus
  Date: 22.06.2021
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateAddress</title>
</head>
<body>
<form action="/user/update/address" method="post">
    <input type="number" name="id">
    <input type="text" placeholder="Street" name="street">
    <input type="number" name="home">
    <button type="submit">Update</button>
</form>

</body>
</html>
