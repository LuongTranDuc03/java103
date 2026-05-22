<%--
  Created by IntelliJ IDEA.
  User: APC
  Date: 5/20/2026
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Students</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 80%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>Students</h2>
<a href="${pageContext.request.contextPath}/students/new">Add student</a>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <c:forEach var="tempStudent" items="${students}">
        <tr>
            <td>${tempStudent.id}</td>
            <td>${tempStudent.name}</td>
            <td>${tempStudent.email}</td>
            <td>${tempStudent.phone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/students/edit?id=${tempStudent.id}" >Edit</a>
                <a href="${pageContext.request.contextPath}/students/delete?id=${tempStudent.id}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
