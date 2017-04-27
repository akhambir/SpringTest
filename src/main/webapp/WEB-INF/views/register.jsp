<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form:form method="post" action="/register" modelAttribute="newUser">
    <form:label path="name">Name</form:label>
    <form:input type="text" path="name"/>

    <form:label path="password">Password</form:label>
    <form:input path="password" type="password"/>
    <button type="submit">Register</button>
</form:form>

</body>
</html>
