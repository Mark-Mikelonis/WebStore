package com.uciext.springfw.project.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.uciext.springfw.project.dao.ProductDao;
import com.uciext.springfw.project.model.Product;
import com.uciext.springfw.project.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private static Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());
	
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

}
