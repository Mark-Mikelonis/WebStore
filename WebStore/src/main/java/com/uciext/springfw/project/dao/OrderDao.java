package com.uciext.springfw.project.dao;

import java.util.List;

import com.uciext.springfw.project.model.Order;

public interface OrderDao {

	public Order getOrderById(int orderId);
	public void insertOrder(Order order);
	public void updateOrder(int orderId, Order order);
	public void deleteOrder(int orderId);
	public List<Order> getProductOrdersByUser(String user);
	List<Order> getProductOrders();
}
