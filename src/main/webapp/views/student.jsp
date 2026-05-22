<%--
  Created by IntelliJ IDEA.
  User: APC
  Date: 5/15/2026
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h1>Detail information</h1>
    <p>
        <b>First name: </b> ${firstName}
    </p>
    <p>
        <b>Last name: </b> ${lastName}
    </p>
    <p>
        <b>From: </b> ${country}
    </p>
    <p>
        <b>Favorite languages: </b>
    </p>
    <c:forEach var="temp" items="${favoriteLanguages}">
        <p>${temp}</p>
    </c:forEach>
</body>
</html>
