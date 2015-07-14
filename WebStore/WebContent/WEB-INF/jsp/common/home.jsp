<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

 <jsp:include page="header.jsp" />
	<br>
	<h2>Home</h2>
	<br>
<!-- <h2><a href="catalog/list.html">Catalog</a></h2>	 -->
<%-- <sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
	<h2><a href="admin/list.html">Admin Products</a></h2>
<%-- </sec:authorize> --%>
<h2><a href="product/list.html">Products</a></h2>
<h2><a href="order/list.html?userName=${pageContext.request.userPrincipal.name}">User Orders</a></h2>

</body>
</html>