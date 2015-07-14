<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>View Order</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
    Order Details:
<br>
<table border="0">
	<tr> 
		<th align="left">Order Id:</th>
    	<td align="left">${order.orderId}</td> 
	</tr> 
	<tr> 
		<th align="left">Created:</th>
    	<td align="left">${order.orderCreated}</td> 
	</tr> 
	<tr>
	<tr> 
		<th align="left">Total Amount:</th>
    	<td align="left">${order.totalAmount}</td> 
	</tr> 
	<tr> 
	<tr> 
		<th align="left">Confirmation #:</th>
    	<td align="left">${order.confirmNumber}</td> 
	</tr> 
	<tr> 
	<tr> 
		<th align="left">User Name:</th>
    	<td align="left">${order.user}</td> 
	</tr> 
	<tr>
		<td><a href="../productorder/list.html?orderId=${order.orderId}">View Order Items</a></td>
	</tr>
	<tr>  
    	<td><a href="edit/${order.orderId}.html">Edit Order Details</a></td> 
	</tr> 
	<tr>
		<td><a href="../product/list.html">Add Items to Order</a></td> 
	</tr>
</table>
<br>
<a href="list.html?userName=${pageContext.request.userPrincipal.name}">Back to Order List</a>
<br><br>

</body>
</html>