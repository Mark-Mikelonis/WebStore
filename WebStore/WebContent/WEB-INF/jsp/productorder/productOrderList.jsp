<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Order List</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
Product Orders:

	<sf:form method="POST" commandName="selectedProductOrders" action="list.html">
		<div>
		<table border="0">
		<tr> <th>Product ID</th><th>Product Title</th><th>Ordered</th>
		</tr>
			<c:forEach var="productOrder" items="${productOrderList}">
				
				
	
				<tr><td><sf:checkbox path="itemList" value="${productOrder.productOrderId}" />
					<c:out value="${productOrder.productId}" /></td>
					<td><c:out value="${productOrder.productName}" /> </td>
					<td align="center"><c:out value="${productOrder.orderAmount}" /></td>
					<td><a href="edit/${productOrder.productOrderId}.html">Change Quantity</a></td>
		</tr>			
			</c:forEach>
		</table>	
		</div>
 		<input type="submit" value="Delete Selected" />
	</sf:form>
	<br>
		
</body>
</html>





