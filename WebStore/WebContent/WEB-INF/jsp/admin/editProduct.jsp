<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Edit Product</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
	Edit Product Details:
	<br>
	<sf:form method="POST" modelAttribute="product">
		<table border="0">
			<tr>
				<th align="left">Product Id:</th>
				<td align="left">${product.productId}</td>
			</tr>
			<tr>
				<th align="left"><label for="catalog_id">Catalog ID:</label></th>
				<td><sf:input path="catalogId" size="20" id="catalog_id" /><br />
					<sf:errors path="catalogId" cssClass="error" /></td>
			</tr>
			<tr>
				<th align="left"><label for="product_name">Product Name:</label></th>
				<td><sf:input path="productName" size="20" id="product_name" /><br />
					<sf:errors path="productName" cssClass="error" /></td>
			</tr>
			<tr>
				<th align="left"><label for="sku">Product SKU:</label></th>
				<td><sf:input path="sku" size="20" id="sku" /><br /> 
				<sf:errors path="sku" cssClass="error" /></td>
			</tr>
			<tr>
				<th align="left"><label for="available_quantity">Available Quantity:</label></th>
				<td><sf:input path="availableQuantity" size="20" id="available_quantity" /><br /> 
				<sf:errors path="availableQuantity" cssClass="error" /></td>
			</tr>
			<tr>
				<th align="left"><label for="uom">Unit of Measure:</label></th>
				<td><sf:input path="unitOfMeasure" size="20" id="uom" /><br /> 
				<sf:errors path="unitOfMeasure" cssClass="error" /></td>
			</tr>
			<tr>
				<th></th>
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