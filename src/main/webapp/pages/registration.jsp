<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yuriymusienko
  Date: 21.06.21
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form action="/user/reg" method="post" modelAttribute="user_reg" >
    <form:input placeholder="Username" path="username"/>
    <form:input placeholder="name" path="name"/>
    <form:input placeholder="Street" path="street"/>
    <form:input placeholder="Home" path="home"/>
    <form:input placeholder="****" type="password" path="password"/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
