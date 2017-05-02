<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
<style>
table, th, td {
	border: 2px solid black;
}
</style>
</head>
<body>
	<h1>Error Creating the following Order</h1>
	<h2>${message}</h2>
		<table>
			<tr>
				<th> Product ID </th>
				<th> Customer ID</th>
				<th> Quantity </th>
			</tr>
			<tr>
				<th> ${pId} </th>
				<th> ${cId} </th>
				<th> ${qty} </th>
			</tr>	
		</table>

	<a href="/">Home</a>
	<a href="/addOrder">new order</a>
	<a href="/logout">log out</a>
</body>
</html>