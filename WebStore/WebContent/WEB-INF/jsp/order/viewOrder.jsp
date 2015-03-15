<html>
<head>
    <title>View Order</title>
</head>
<body>
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
		<th></th>
    	<td><a href="edit/${order.orderId}.html">Edit</a></td> 
	</tr> 
</table>
<br>
<a href="list.html">Back to Order List</a>
<br><br>

</body>
</html>