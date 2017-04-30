<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Products</title>
<style>
table, th, td {
	border: 2px solid black;
}
</style>
</head>
<body>
	<h1>List of Products</h1>
	<table>
		<tr>
			<th>Product ID</th>
			<th>Description</th>
			<th>Quantity in Stock</th>
		</tr>
		<tr>
			<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.pId}</td>
				<td>${product.pDesc}</td>
				<td>${product.qtyInStock}</td>
			</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="/">Home</a>
	<a href="/addProducts">Add Product</a>
	<a href="/listProducts">List Products</a>
	<a href="/listOrders">List Orders</a>
	<a href="/logout">Log out</a>
</body>
</html>