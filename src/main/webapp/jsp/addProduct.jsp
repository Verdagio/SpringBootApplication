<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add products</title>
</head>
<body>
	<form:form modelAttribute="newProduct">
		<h1>Add new product</h1>
		<table>
			<tr>
				<td>Product Description</td>
				<td><form:input path="pDesc"></form:input></td>
				<td><form:errors path="pDesc">may not be empty</form:errors></td>
			</tr>
			<tr>
				<td>Quantity in Stock</td>
				<td><form:input path="qtyInStock"></form:input></td>
				<td><form:errors path="qtyInStock">must be greater than 0</form:errors></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add"/></td>
		</table>
		<a href="/">Home</a>
		<a href="/showOrders">List Orders</a>
		<a href="/showProducts">List Products</a>
	</form:form>
</body>
</html>