<%--
  Created by IntelliJ IDEA.
  User: APC
  Date: 5/22/2026
  Time: 8:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Add New Student</title>
</head>
<body>
    <h2>Add Student</h2>
    <form action="${pageContext.request.contextPath}/students/insert" method="post">
        <table>
            <tr>
                <td><label>Id</label></td>
                <td><input type="text" name="id" value="${not empty student.id ? student.id : param.id}"></td>
            </tr>
            <tr>
                <td><label>Name</label></td>
                <td><input type="text" name="name" value="${student.name}"></td>
                <td>
                    <c:if test="${not empty errorMessage}">
                        <p style="color: red">${errorMessage}</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><input type="text" name="email" value="${student.email}"></td>
            </tr>
            <tr>
                <td><label>Phone</label></td>
                <td><input type="text" name="phone" value="${student.phone}"></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>
</body>
</html>
