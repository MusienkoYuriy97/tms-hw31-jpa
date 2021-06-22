<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 97mus
  Date: 21.06.2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form action="/user/update" method="post" modelAttribute="user_update" >
    <form:input path="id"/>
    <form:input placeholder="Username" path="username"/>
    <form:input placeholder="name" path="name"/>
    <form:input placeholder="Street" path="street"/>
    <form:input path="home"/>
    <form:input placeholder="****" type="password" path="password"/>
    <button type="submit">Update</button>
</form:form>
</body>
</html>
