<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
    Product Details:
<br>
<sf:form method="POST" modelAttribute="product">
<table border="0">
	<tr> 
		<th align="left">Product Id:</th>
    	<td align="left">${product.productId}</td> 
	</tr> 
	<tr> 
		<th align="left">Product Name:</th>
    	<td align="left">${product.productName}</td> 
	</tr> 
	<tr>
	<tr> 
		<th align="left">Product SKU:</th>
    	<td align="left">${product.sku}</td> 
	</tr> 
	<tr> 
	<tr> 
		<th align="left">Available Quantity:</th>
    	<td align="left">${product.availableQuantity}</td> 
	</tr> 
	<tr> 
	<tr> 
		<th align="left">Unit of Measure:</th>
    	<td align="left">${product.unitOfMeasure}</td> 
	</tr> 
<!-- 	<tr>   -->
<!-- 		<th></th> -->
<%--     	<td><a href="edit/${product.productId}.html">Edit</a></td>  --%>
<!-- 	</tr>  -->
</table>
<input type="submit" value="Add to Order" />
	</sf:form>
<br>
<a href="">Add Product to Order</a>
<a href="list.html">Back to Product List</a>
<br><br>

</body>
</html>