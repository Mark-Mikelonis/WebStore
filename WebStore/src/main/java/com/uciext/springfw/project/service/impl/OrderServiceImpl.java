package com.uciext.springfw.project.service.impl;

import java.util.List;

import com.uciext.springfw.project.dao.OrderDao;
import com.uciext.springfw.project.model.Order;
import com.uciext.springfw.project.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	
	@Override
	public Order getOrderById(int orderId) {
		return orderDao.getOrderById(orderId);
	}

	@Override
	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
		
	}

	@Override
	public void updateOrder(int orderId, Order order) {
		orderDao.updateOrder(orderId, order);
	}

	@Override
	public void deleteOrder(int orderId) {
		orderDao.deleteOrder(orderId);
		
	}

	@Override
	public List<Order> getOrdersByUser(String user) {
		return orderDao.getProductOrdersByUser(user);
	}



	@Override
	public List<Order> getOrders() {
		return orderDao.getProductOrders();
	}


}
