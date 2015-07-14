package com.thricethree.spring.crud.service;

import java.util.List;

import com.thricethree.spring.crud.model.ProductOrder;

public interface ProductOrderService {

	public List<ProductOrder> getProductOrderByOrderId(int orderId);
	public List<ProductOrder> getProductOrders();
	public void deleteProductOrder(int productOrderId);
	public ProductOrder getProductOrderByProductOrderId(int productOrderId);
	public void updateProductOrder(int orderId, ProductOrder productOrder);
	public void insertProductOrder(ProductOrder productOrder);
}
