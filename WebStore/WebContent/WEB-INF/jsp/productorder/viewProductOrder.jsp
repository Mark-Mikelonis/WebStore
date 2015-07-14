<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Product Details</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
Order Product Details:
		<div>
			<c:forEach var="productOrder" items="${productOrderList}">
<%-- 				<sf:checkbox path="itemList" value="${product.productId}" /> --%>
				<tr><td>
				<a href="view.html?productId=${productOrder.productOrderId}">
					<c:out value="${productOrder.productOrderId}" />
				</a>
				</td>
				</tr>
			</c:forEach>
		</div>
</body>
</html>