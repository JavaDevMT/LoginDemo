<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
       
        String firstName = (String) session.getAttribute("reguser");

        if (firstName != null) {
    %>
            <p>Welcome, <%= firstName %> your registration is success!</p>
            <a href="login">Login Here</a>
    <%
        } else {
    %>
            <p>No user information found in session.</p>
    <%
        }
    %>
</body>
</html>