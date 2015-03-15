<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
</head>
<body>

Add New Product:
<br>
<sf:form method="POST" modelAttribute="product">
<table border="0">
	<tr> 
		
		<td><sf:input type="hidden" path="productId" id="product_id" value="0" /><br/>
        	<sf:errors path="productId" cssClass="error" /> 
    	</td>
    	<td><sf:input type="hidden" path="catalogId" id="catalog_id" value="74563" /><br/>
        	<sf:errors path="productId" cssClass="error" /> 
    	</td>
    </tr>
     <tr>
     	<th><label for="sku">Product SKU:</label></th>	
    	<td><sf:input path="sku" size="10" id="sku" /><br/>
        	<sf:errors path="sku" cssClass="error" /> 
    	</td>  
	</tr> 
    <tr>
    	<th><label for="product_name">Product Name:</label></th>	  
    	<td><sf:input path="productName" size="20" id="product_name" /><br/>
        	<sf:errors path="productName" cssClass="error" /> 
    	</td>
    </tr>
   
	<tr>
		<th><label for="available_quantity">Available Quantity:</label></th>
    	<td><sf:input path="availableQuantity" size="10" id="available_quantity" /><br/>
        	<sf:errors path="availableQuantity" cssClass="error" /> 
    	</td>  
	</tr> 
	<tr>
		<th><label for="uom">Unit of Measure:</label></th>	
    	<td><sf:input path="unitOfMeasure" size="20" id="uom" /><br/>
        	<sf:errors path="unitOfMeasure" cssClass="error" /> 
    	</td>  
	</tr> 
	<tr>
		<th></th>
		<td><input type="submit" value="Save" /></td>
	</tr>
</table>
</sf:form>
    
</body>
</html>