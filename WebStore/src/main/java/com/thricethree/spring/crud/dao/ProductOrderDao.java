package com.thricethree.spring.crud.dao;

import java.util.List;

import com.thricethree.spring.crud.model.ProductOrder;

public interface ProductOrderDao {

	public List<ProductOrder> getProductOrderByOrderId(int orderId);
	public void insertProductOrder(ProductOrder productOrder);
	public void updateProductOrder(int productOrderId, ProductOrder productOrder);
	public void deleteProductOrder(int productOrderId);
	public List<ProductOrder> getProductOrders();
	ProductOrder getProductOrderByProductOrderId(int productOrderId);
	
}
