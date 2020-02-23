<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter the Specified Details : </title>
</head>
<body>

<a href = "index.jsp">Home</a>


<form name = "login form" method ="post" action="UserLogin">
<br><br>
<input type ="text" placeholder = "Name" name="username">
<br><br>
<input type = "text" placeholder = "Password" name="password">
<br><br>
<input type ="submit" value ="LOGIN">

<a href = "saveuser.jsp">New User?</a>

</body>
</html>