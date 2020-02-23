<%-- <%@ include file="logininc.jsp"%> --%>
<html>
<head>
</head>
<body>
	<tr>
		<td>Welcome to your online wallet</td>
		<!-- <title>Welcome to your online wallet</title> -->
	</tr>
	<br>
	<br>

	<%
		if (session.getAttribute("userid") == null) {
	%>
	<tr>
		<a href="login.jsp">Login</a>
	</tr>
	<br>
	<tr>
		<a href="saveuser.jsp">Register</a>
	</tr>
	<%
		}
	%>
	</table>

</body>
</html>

<

