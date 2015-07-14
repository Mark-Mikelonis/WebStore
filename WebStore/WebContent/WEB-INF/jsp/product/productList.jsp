<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Product List</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
	Products:
	
	<sf:form method="POST" commandName="selectedProducts" action="../productorder/listadd.html?user=${pageContext.request.userPrincipal.name}">
		<div>
			<c:forEach var="product" items="${productList}">
				<sf:checkbox path="itemList" value="${product.productId}" />
				<a href="view.html?productId=${product.productId}">
					<c:out value="${product.productName}" />
				</a>
				<br>
			</c:forEach>
		</div>
 		<input type="submit" value="Add to Order" />
	</sf:form>
	<br>
	
</body>
</html>