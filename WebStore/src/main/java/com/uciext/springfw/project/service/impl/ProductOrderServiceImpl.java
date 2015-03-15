package com.uciext.springfw.project.service.impl;

import java.util.List;


import com.uciext.springfw.project.dao.ProductOrderDao;
//import com.uciext.springfw.project.model.Order;
//import com.uciext.springfw.project.model.Product;
import com.uciext.springfw.project.model.ProductOrder;
import com.uciext.springfw.project.service.ProductOrderService;

public class ProductOrderServiceImpl implements ProductOrderService {

	ProductOrderDao productOrderDao;
	
	
	public void setProductOrderDao(ProductOrderDao productOrderDao) {
		this.productOrderDao = productOrderDao;
	}

	@Override
	public ProductOrder getProductOrderByProductOrderId(int productOrderId) {
		
		return productOrderDao.getProductOrderByProductOrderId(productOrderId);
	}

	@Override
	public ProductOrder getProductOrderByOrderId(int orderId) {
		return productOrderDao.getProductOrderByOrderId(orderId);
	}

	@Override
	public List<ProductOrder> getProductOrders() {
		return productOrderDao.getProductOrders();
	}

}
