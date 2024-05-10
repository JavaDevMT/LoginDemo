<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<table>
<form method="post" action="/HelloWorld/register">
<th>Register Your details</th>
<tr><td>First Name</td><td><input type="text" name="fname"/></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lname"/></td></tr>
<tr><td>Email</td><td><input type="email" name="email"/></td></tr>
<tr><td>UserName</td><td><input type="username" name="username"/></td></tr>
<tr><td>Password</td><td><input type="password" name="password"/></td></tr>
<tr><td></td><td><input type="submit" name="submit"/></td></tr>
</form>
</table>
</body>
</html>