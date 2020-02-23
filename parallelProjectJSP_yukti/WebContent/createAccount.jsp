<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<td>Create your new Account</td>
</head>
<body>
	<form action="Welcome" name="Account Details" method="post">

		<input type="text" placeholder="Enter your name " name="customer name">
		<br> <br> <input type="text" placeholder="Contact Number"
			name="phonenumber"> <br> <br> <label
			for="Account type"> Account type :</label><br> <label
			for="Savings"> Savings : </label> <input type="radio" name="type"
			value="sav"><br> <br> <label for="Fixed">Fixed
			: </label><br> <input type="radio" name="type" value="fix"><br>
		<br> <label for="Checking">Checking: </label><br> <input
			type="radio" name="type" value="check"><br> <br> <label
			for="Balance">Balance :</label><br> <input type="text"
			placeholder="Balance" name="bal"> <br> <br> <input
			type="submit" value="SUBMIT">
</body>
</html>