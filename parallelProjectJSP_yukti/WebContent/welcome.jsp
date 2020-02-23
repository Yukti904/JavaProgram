<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">

<td>Options available</td>
<br>
<br>
</head>
<body>
	<%
		if (session.getAttribute("username") != null && session.getAttribute("password") != null) {
	%>
	<td>Choose your option</td>
	<a href="createAccount.jsp"> Create your account</a>
	<br>
	<br>
	<a href="Deposit.jsp"> Deposit</a>
	<br>
	<br>
	<a href="withdraw.jsp"> Withdraw</a>
	<br>
	<br>
	<a href="fetchDetails.jsp">Fetch Account Details</a>
	<br>
	<br>
	<a href="checkBalance.jsp">Check your balance</a>
	<br>
	<br>
	<a href="fundTransfer.jsp">Fund transfers</a>
	<br>
	<br>
	<a href="printTransaction.jsp">Print Transactions</a>
	<br>
	<%
		}
	%>

	<br>


</body>
</html>