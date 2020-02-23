<html>
<body>

	<title></title>
	<a href="index.jsp">Home</a>


	<%
		if ((session.getAttribute("userid") != null)) {
	%>

	<a href="welcome.jsp">My Account</a>
	<br>
	<a href="logout.jsp">Logout</a>
	<br>
	<%
		}
	%>
	</td>
	</tr>
	</table>
</body>
</html>

