<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<form:form modelAttribute="customer1">
		<h1>Add new customer</h1>
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="cName"></form:input></td>
				<td><form:errors path="cName"></form:errors></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add"/></td>
			</tr>
		</table>
		<a href="/">Home</a>
		<a href="/listOrders">List Orders</a>
		<a href="/listProducts">List Products</a>
		<a href="/signOut">Sign Out</a>
	</form:form>
</body>
</html>