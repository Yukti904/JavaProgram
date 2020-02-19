

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.getSession(false);
		if (session == null) {
	%>
	<a href="http://localhost:8090/loginDemo/home.jsp"> Home</a>
	<a href="http://localhost:8090/loginDemo/login.jsp"> Login</a>
	<%
		} else {
			// Already created.
	%>
	<a href="http://localhost:8090/loginDemo/logout.jsp"> Logout</a>
	<%
		}
		String name = request.getParameter("name");
	%>
	<br>
	<br>
	<%
		out.println("Welcome: " + name);
	%>
</body>
</html>