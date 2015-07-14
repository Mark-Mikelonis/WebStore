package com.thricethree.spring.crud.service.impl;

import java.util.List;

import com.thricethree.spring.crud.dao.ProductOrderDao;
//import com.uciext.springfw.project.model.Order;
//import com.uciext.springfw.project.model.Product;
import com.thricethree.spring.crud.model.ProductOrder;
import com.thricethree.spring.crud.service.ProductOrderService;

public class ProductOrderServiceImpl implements ProductOrderService {

	ProductOrderDao productOrderDao;
	
	
	public void setProductOrderDao(ProductOrderDao productOrderDao) {
		this.productOrderDao = productOrderDao;
	}

	@Override
	public List<ProductOrder> getProductOrderByOrderId(int orderId) {
		return productOrderDao.getProductOrderByOrderId(orderId);
	}

	@Override
	public List<ProductOrder> getProductOrders() {
		return productOrderDao.getProductOrders();
	}

	@Override
	public void deleteProductOrder(int productOrderId) {
		productOrderDao.deleteProductOrder(productOrderId);
	}

	@Override
	public ProductOrder getProductOrderByProductOrderId(int productOrderId) {
		return productOrderDao.getProductOrderByProductOrderId(productOrderId);
	}

	@Override
	public void updateProductOrder(int productOrderId, ProductOrder productOrder) {
		productOrderDao.updateProductOrder(productOrderId, productOrder);
	}

	@Override
	public void insertProductOrder(ProductOrder productOrder) {
		productOrderDao.insertProductOrder(productOrder);
	}


}
