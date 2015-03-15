package com.uciext.springfw.project.service;

import java.util.List;
import com.uciext.springfw.project.model.ProductOrder;

public interface ProductOrderService {

	public ProductOrder getProductOrderByProductOrderId(int productOrderId);
	public ProductOrder getProductOrderByOrderId(int orderId);
	public List<ProductOrder> getProductOrders();
}
