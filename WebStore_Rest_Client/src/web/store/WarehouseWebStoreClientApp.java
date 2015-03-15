package web.store;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import web.store.rest.client.ProductClient;
import web.store.rest.model.Product;

public class WarehouseWebStoreClientApp {
	public static void main(String[] args) throws Exception {
		WarehouseWebStoreClientApp wSClientApp = new WarehouseWebStoreClientApp();
		wSClientApp.run();
    }
	
	
	public void run(){
		ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("/META-INF/spring/WebStoreClientContext.xml");
        ProductClient productClient = (ProductClient) context.getBean("productClient");
	
     // Get all Products  
        System.out.println("\n==== Get Products ====");
    	ArrayList<Product> products = productClient.getProducts();
    	System.out.println("---- Total products=" + products.size());
    	for (int i=0; i<products.size(); i++) {
    	    System.out.println("Product[" + i + "]=" + products.get(i));	
    	}
	
    	// Get Products by Id    	
    	System.out.println("\n==== Get Products by Id ====");
       	System.out.println("----   [id=" + products.get(0).getProductId() + "] " + productClient.getProduct(products.get(0).getProductId()));
       	System.out.println("----   [id=" + products.get(1).getProductId() + "] " + productClient.getProduct(products.get(1).getProductId()));
    	// Add a new product
       	System.out.println("\n==== Add new Product ====");
    	Product product = new Product();
    	product.setProductName("Java for Champs!");
    	product.setCatalogId(74563);
    	product.setAvailableQuantity(13);
    	product.setSku("B-264789");
    	product.setUnitOfMeasure("pages");
    	productClient.createProduct(product);

    	products = productClient.getProducts();
    	for (int i=0; i<products.size(); i++) {
    	    System.out.println("product[" + i + "]=" + products.get(i));	
    	}
       	

    	// Update a product
    	System.out.println("\n==== Update a product ====");
    	product = products.get(products.size()-1);
    	product.setProductName(product.getProductName() + " 333");
    	System.out.println(product);
    	productClient.updateProduct(product);

    	products = productClient.getProducts();
    	for (int i=0; i<products.size(); i++) {
    	    System.out.println("product[" + i + "]=" + products.get(i));	
    	}
    	
    	
    	// Delete a product
    	System.out.println("\n==== Delete a product ====");
    	product = products.get(products.size()-1);
    	productClient.deleteProduct(product);

    	products = productClient.getProducts();
    	for (int i=0; i<products.size(); i++) {
    	    System.out.println("product[" + i + "]=" + products.get(i));	
    	}
    
       	
	
	}
}
