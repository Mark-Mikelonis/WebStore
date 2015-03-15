<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order List</title>
</head>
<body>
	Orders:
	
	<sf:form method="POST" commandName="selectedOrders" action="list.html">
		<div>
			<c:forEach var="order" items="${orderList}">
				<sf:checkbox path="itemList" value="${order.orderId}" />
				<a href="view.html?orderId=${order.orderId}">
					<c:out value="${order.orderId}" />
				</a>
				<br>
			</c:forEach>
		</div>
 		<input type="submit" value="Delete" />
	</sf:form>
	<br>
	<a href="add.html">Add New</a>
</body>
</html>