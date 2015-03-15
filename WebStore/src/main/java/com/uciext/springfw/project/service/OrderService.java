package com.uciext.springfw.project.service;

import java.util.List;

import com.uciext.springfw.project.model.Order;

public interface OrderService {

	public Order getOrderById(int orderId);
	public void insertOrder(Order order);
	public void updateOrder(int orderId, Order order);
	public void deleteOrder(int orderId);
	public List<Order> getOrdersByUser(String user);
	public List<Order> getOrders();
}
