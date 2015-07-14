<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Product Quantities</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
	Edit Product Quantities:
	<br>
	<sf:form method="POST" modelAttribute="productOrder">
		<table border="0">
			<tr>
<!-- 				<th align="left">Product Title:</th> -->
<%-- 				<td align="left">${productOrder.productName}</td> --%>
				<td><sf:input type="hidden" path="productOrderId"  id="product_order_id" value="${productOrder.productOrderId}"/><br />
					<sf:errors path="productOrderId" cssClass="error" /></td>
					<td><sf:input type="hidden" path="orderId"  id="order_id" value="${productOrder.orderId}"/><br />
					<sf:errors path="orderId" cssClass="error" /></td>
					<td><sf:input type="hidden" path="productId"  id="product_id" value="${productOrder.productId}"/><br />
					<sf:errors path="productId" cssClass="error" /></td>
			</tr>
			<tr>
				<th align="left"><label for="order_amount">Quantity Ordered:</label></th>
				<td><sf:input path="orderAmount" size="6" id="order_amount" /><br />
					<sf:errors path="orderAmount" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</sf:form>
	
	

	<br>
	<a href="../list.html?orderId=${productOrder.orderId}">Cancel</a>
	<br>
	<br>

</body>
</html>