<%-- 
<%@ page import="com.ibm.wallet1.dao.Registration"%>
<%@ page contentType="text/html"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%
	RequestDispatcher rd = request.getRequestDispatcher("/register");
	rd.forward(request, response);
 --%>

<html>
<head>
<meta charset="ISO-8859-1">
<td>Register yourself by filling in the following details</td>
</head>
<body>

	<form name=" Registration Form " method="post" action="register">
	<br>
	<br>
	<input type="text" placeholder="FullName" name="name">
	<br>
	<br>
	<input type="text" placeholder="Email ID" name="email">
	<br>
	<br>
	<input type="text" placeholder="Password" name="password">
	<br>
	<br>

	<input type="submit" value="REGISTER">
</form>
</body>
</html>
