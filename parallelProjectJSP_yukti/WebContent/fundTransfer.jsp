<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<td>Fund Transfer : </td>
</head>
<body>

<form action="welcome5" method="post">
<td>Enter the Account ID from where the amount is debited : </td><br><br>

<input type ="text" placeholder="From Account ID" name="from accountID">
<br>
<br>
<td>Enter the Account ID to where the amount is credited : </td><br><br>

<input type="text" placeholder ="To Account ID" name="to accountID">
<br>
<br>

<td>Enter the amount to be transfered : </td><br><br>

<input type="text" placeholder="Amount" name="amount">
<br>
<br>
<input type ="submit" value="TRANSFER">

</body>
</html>