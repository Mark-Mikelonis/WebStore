<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Catalog List</title>
</head>
<body>
	Catalogs:
	
<div>
			<c:forEach var="catalog" items="${catalogList}">
				<a href="view.html?catalogId=${catalog.catalogId}">
					<c:out value="${catalog.catalogName}" />
				</a>
				<br>
			</c:forEach>
		</div>
<a href="add.html">Add New Catalog</a>
</body>
</html>