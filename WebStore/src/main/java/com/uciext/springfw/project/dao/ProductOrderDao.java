package com.uciext.springfw.project.dao;

import java.util.List;

import com.uciext.springfw.project.model.ProductOrder;

public interface ProductOrderDao {

	public ProductOrder getProductOrderByProductOrderId(int productOrderId);
	public ProductOrder getProductOrderByOrderId(int orderId);
	public void insertProductOrder(ProductOrder productOrder);
	public void updateProductOrder(int productOrderId, ProductOrder productOrder);
	public void deleteProductOrder(int productOrderId);
	public List<ProductOrder> getProductOrders();
	
}
