<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order List</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<%-- <c:if test="${userName == null}"> --%>
<%-- 	<c:redirect url="list.html?userName=${pageContext.request.userPrincipal.name}"/> --%>
<%-- 	</c:if> --%>
	Orders:
	
		<div>
			<c:forEach var="order" items="${orderList}">
				<a href="view.html?orderId=${order.orderId}">
					<c:out value="${order.orderId}" />
				</a>
				<br>
			</c:forEach>
		</div>
	<br>
	<a href="add.html">Create New Order</a>
</body>
</html>