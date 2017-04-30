<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
<style>
table, th, td {
	border: 2px solid black;
}
</style>
</head>
<body>
	<h1>Customers</h1>
	<c:forEach items="${customers}" var="customer">
		<h1>${customer.cId} ${customer.cName}</h1>
		<h3>${customer.cName}'s Orders</h3>
		<table>
			<tr>
				<th>Order Id</th>
				<th>Quantity</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>	
			<tr>
				<c:forEach items="${customer.orders}" var="order">
					<td>${order.oId}</td>
					<td>${order.qty}</td>
					<td>${order.prod.pId}</td>
					<td>${order.prod.pDesc}</td>
				</c:forEach>
			</tr>
		</table>
	</c:forEach>
	<a href="/">Home</a>
	<a href="/addCustomers">Add Customer</a>
	<a href="/listProducts">List Products</a>
	<a href="/listOrders">List Orders</a>
	<a href="/logout">Log out</a>
</body>
</html>