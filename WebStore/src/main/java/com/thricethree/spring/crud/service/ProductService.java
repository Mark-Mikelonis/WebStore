package com.thricethree.spring.crud.service;

import java.util.List;

import com.thricethree.spring.crud.model.Product;

public interface ProductService {

	public Product getProduct(int productId);
	public void insertProduct(Product product);
	public void updateProduct(int productId, Product product);
	public void deleteProduct(int productId);
	public List<Product> getProducts();
	public List<Product> getProductsAdmin();
}
