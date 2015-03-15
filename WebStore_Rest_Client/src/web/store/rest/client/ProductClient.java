package web.store.rest.client;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import web.store.rest.model.Product;
import web.store.rest.model.ProductList;

public class ProductClient {

	private RestTemplate restTemp;

	@Inject
	public void setRestTemp(RestTemplate restTemp) {
		this.restTemp = restTemp;
	}
	
	// Get all Products
	public ArrayList<Product> getProducts(){
		System.out.println("==== Client: getProducts() ====");
		ProductList productList = restTemp.getForObject("http://localhost:8080/WebStore/rest/products", 
				ProductList.class);
		return productList.getProducts();
				
	}
	
	// Get a Product by id
	public Product getProduct(int productId) {
		System.out.println("==== Client: getProduct() ====");
		Product product = restTemp.getForObject("http://localhost:8080/WebStore/rest/products/{prodId}", 
				Product.class, productId) ;
		return product;
	}
	
	// Create a new Product
	@SuppressWarnings("rawtypes")
	public void createProduct(Product product){
		System.out.println("==== Client: createProduct() ====");
		ResponseEntity response = restTemp.postForEntity("http://localhost:8080/WebStore/rest/products", 
				product, null);
		if (response.getStatusCode() != HttpStatus.CREATED){
			throw new RuntimeException("Error creating product");
		}
	}
	
	// Update a product
	public void updateProduct(Product product){
		System.out.println("==== Client: updateProduct() ====");
		restTemp.put("http://localhost:8080/WebStore/rest/products/{productId}", 
				product, product.getProductId());
		
	}
	
	// Delete a Product
	public void deleteProduct(Product product){
		System.out.println("==== Client: deleteProduct() ====");
		restTemp.delete("http://localhost:8080/WebStore/rest/products/{prodId} ", 
				product.getProductId());
	}
	
}
