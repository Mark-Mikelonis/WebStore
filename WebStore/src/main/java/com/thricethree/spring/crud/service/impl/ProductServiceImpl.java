package com.thricethree.spring.crud.service.impl;

import java.util.List;

import com.thricethree.spring.crud.dao.ProductDao;
import com.thricethree.spring.crud.model.Product;
import com.thricethree.spring.crud.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	@Override
	public void insertProduct(Product product) {
		productDao.insertProduct(product);
		
	}

	@Override
	public void updateProduct(int productId, Product product) {
		productDao.updateProduct(productId, product);
		
	}

	@Override
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
		
	}

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public List<Product> getProductsAdmin() {
		return productDao.getProductsAdmin();
	}


}
