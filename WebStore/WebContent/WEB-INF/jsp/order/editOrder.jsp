<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Order</title>
</head>




<body>
<jsp:include page="../common/header.jsp" />
	Edit Order Details:
	<br>
	<sf:form method="POST" modelAttribute="order">
		<table border="0">
			<tr>
				<th align="left">Order Id:</th>
    			<td align="left">${order.orderId}</td>
    			<td><sf:input type="hidden" path="orderId"  id="order_id" value="${order.orderId}"/><br />
					<sf:errors path="orderId" cssClass="error" /></td> 
			</tr>
			<tr> 
				<th align="left">Created:</th>
    			<td align="left">${order.orderCreated}</td> 
			</tr> 
			<tr>
				<th align="left"><label for="total_amount">Total Amount:</label></th>
				<td><sf:input path="totalAmount" size="20" id="total_amount" /><br />
					<sf:errors path="totalAmount" cssClass="error" /></td>
			</tr>
			<tr>
				<th align="left"><label for="confirm_number">Confirmation #:</label></th>
				<td><sf:input path="confirmNumber" size="20" id="confirm_number" /><br /> 
				<sf:errors path="confirmNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<th align="left"><label for="user">User Name:</label></th>
				<td><sf:input path="user" size="20" id="user" /><br /> 
				<sf:errors path="user" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</sf:form>

	<br>
	<a href="../list.html?userName=${order.user}">Cancel</a>
	<br>
	<br>

</body>
</html>