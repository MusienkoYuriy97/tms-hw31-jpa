<%--
  Created by IntelliJ IDEA.
  User: yuriymusienko
  Date: 21.06.21
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <div class="alert alert-primary" role="alert">
        Username:${user.username}; Name:${user.name}; Address: ${user.address.street} ${user.address.home};
    </div>
</c:forEach>
</body>
</html>
