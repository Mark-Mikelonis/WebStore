package com.uciext.springfw.project.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.uciext.springfw.project.model.Product;
import com.uciext.springfw.project.model.ProductList;
import com.uciext.springfw.project.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductRestService {

	

	private ProductService productService;
	
	@Inject
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	// View List of Products
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public @ResponseBody ProductList productsList(){
		System.out.println("==== in productsList (REST) ====");
		List<Product> prodList = productService.getProducts();
		
		// Convert to ProductList 
		ProductList productList = new ProductList();
		for(Product product: prodList){
			productList.getProducts().add(product);
		}
		return productList;
		
	}
	
	// View Product Details
	@RequestMapping(value="/products/{productId}", method=RequestMethod.GET)
	public @ResponseBody Product productView(@PathVariable("productId") int productId){
		System.out.println("==== in productView (REST) ====");
		Product product = productService.getProduct(productId);
		return product;
	}
	
	// Update Product
	@RequestMapping(value="/products/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@PathVariable int productId, @Valid @RequestBody Product product){
		System.out.println("==== in updateProduct (REST) ====");
		productService.updateProduct(productId, product);
	}
	
	// Add Product
	@RequestMapping(value="/products", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduct(@Valid @RequestBody Product product){
		System.out.println("==== in addProduct (REST) ====");
		productService.insertProduct(product);
	}
	
	// Delete Product
	@RequestMapping(value="/products/{productId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable int productId){
		System.out.println("==== in deleteProduct (REST) ====");
		productService.deleteProduct(productId);
	}
	
	
}
