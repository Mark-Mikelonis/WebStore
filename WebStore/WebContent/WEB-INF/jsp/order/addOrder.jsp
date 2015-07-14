<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Order</title>
</head>




<body>
<jsp:include page="../common/header.jsp" />
	Add Order:
	<br>
	<sf:form method="POST" modelAttribute="order">
		<table border="0">
			<tr>
				<th align="left">Order Id:</th>
    			<td align="left">${order.orderId}</td>
    			<td><sf:input type="hidden" path="orderId" id="order_id" value="${order.orderId}" /><br/>
        		<sf:errors path="orderId" cssClass="error" />
        		<c:set var="openId" value="${order.orderId}"/> 
    	</td>
    		</tr>	
    			<tr>
				<th align="left"><label for="user">User Name:</label></th>
				<td align="left">${order.user}</td>
				<td><sf:input type="hidden" path="user" id="user" value="${order.user}" /><br/>
        		<sf:errors path="user" cssClass="error" />
			</tr>
    			<tr>
				<th align="left"><label for="orderCreated">Order Created:</label></th>
				<td align="left">${order.orderCreated}</td>
			</tr>
			<tr>
				<th align="left">Total Amount:</th>
    			<td align="left">${order.totalAmount}</td>
    			<td><sf:input type="hidden" path="totalAmount" id="total_amount" value="${order.totalAmount}" /><br/>
        		<sf:errors path="totalAmount" cssClass="error" /> 
    	</td>
			</tr>
			<tr>
				<th align="left"><label for="confirm_number">Confirmation #:</label></th>
				<td><sf:input path="confirmNumber" size="20" id="confirm_number" value="${order.confirmNumber}" /><br /> 
				<sf:errors path="confirmNumber" cssClass="error" /></td>
			</tr>
			<tr> 
		
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</sf:form>

	<br>
	<a href="../list.html">Cancel</a>
	<br>
	<br>

</body>
</html>