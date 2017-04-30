<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List orders</title>
<title>List Products</title>
<style>
table, th, td {
	border: 2px solid black;
}
</style>
</head>
<body>
	<h1>List of Orders</h1>
	<c:forEach items="${orders}" var="order">
	<br>
	<h3>${order.oId}</h3>
		<table>
			<tr>
				<th>Quantity</th>
				<th>Order date</th>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Product Id</th>
				<th>Description</th>
			<tr>
			<tr>
				<td>${order.qty}</td>
				<td>${order.orderDate}</td>
				<td>${order.cust.cId}</td>
				<td>${order.cust.cName}</td>
				<td>${order.prod.pId}</td>
				<td>${order.prod.pDesc}</td>
			</tr>
		</table>	
	</c:forEach>
	<a href="/">Home</a>
	<a href="/addOrders">Add Order</a>
	<a href="/listProducts">List Products</a>
	<a href="/listOrders">List Orders</a>
	<a href="/logout">Log out</a>

</body>
</html>