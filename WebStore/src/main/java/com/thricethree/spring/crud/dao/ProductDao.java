package com.thricethree.spring.crud.dao;

import java.util.List;

import com.thricethree.spring.crud.model.Product;

public interface ProductDao {

	//Products
		public Product getProduct(int productId);
		public void insertProduct(Product product);
		public void updateProduct(int productId, Product product);
		public void deleteProduct(int productId);
		public List<Product> getProductsByCatalogId(int catalogId);
		public List<Product> getProducts();
		public List<Product> getProductsAdmin();
}
