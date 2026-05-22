<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<p>SD21301</p>
<%--1. expressions (biểu thức) --%>
<p>The time on server: <%= new java.util.Date() %> </p>
<p>Converting to Upper case: <%= new String("Hello World!").toUpperCase() %></p>
<p>Summary of 3 and 5: <%= 3 + 5%></p>

<%--2. scriptlet (đoạn mã nhỏ) --%>
<%
    for (int i=1; i<=5; i++){
        out.println("Item " + i);
        out.println("<br>");
    }
%>

<%--3. declaration (khai báo) --%>
<%!
    String toLower(String s) {
        return s.toLowerCase();
    }
%>

<p>Lower case of "HELLO WORLD": <%= toLower("HELLO WORLD")%></p>

<form action="StudentServlet">
    First name: <input type="text" name="firstName"><br>
    Last name: <input type="text" name="lastName"><br>

    <br>
    <select name="country">
        <option>Viet Nam</option>
        <option>Trung Quoc</option>
        <option>Thai Lan</option>
        <option>Nhat Ban</option>
    </select>

    <br>
    <input type="checkbox" name="favoriteLanguage" value="Java">Java
    <input type="checkbox" name="favoriteLanguage" value="JavaScript">JavaScript
    <input type="checkbox" name="favoriteLanguage" value="C#">C#
    <input type="checkbox" name="favoriteLanguage" value="Kotlin">Kotlin
    <input type="checkbox" name="favoriteLanguage" value="Other">Other...
    <br>
    <input type="submit" value="Submit">
</form>

<a href="hello-servlet">Hello Servlet</a>
<br><br>
<form action="students" method="GET">
    <button type="submit" style="padding: 10px 20px; font-size: 16px; cursor: pointer; background-color: #4CAF50; color: white; border: none; border-radius: 5px;">
        Xem danh sách sinh viên
    </button>
</form>
</body>
</html>