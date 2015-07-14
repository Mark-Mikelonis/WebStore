package com.thricethree.spring.crud.dao;

import java.util.List;

import com.thricethree.spring.crud.model.Order;

public interface OrderDao {

	public Order getOrderById(int orderId);
	public void insertOrder(Order order);
	public void updateOrder(int orderId, Order order);
	public void deleteOrder(int orderId);
	public List<Order> getProductOrdersByUser(String user);
	List<Order> getProductOrders();
	public Order getLastInsert();
	public int getCart(String user);
}
