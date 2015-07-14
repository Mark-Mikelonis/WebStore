package com.thricethree.spring.crud.service.impl;

import java.util.List;

import com.thricethree.spring.crud.dao.OrderDao;
import com.thricethree.spring.crud.model.Order;
import com.thricethree.spring.crud.service.OrderService;

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



	@Override
	public Order getLastInsert() {
		// TODO Auto-generated method stub
		return orderDao.getLastInsert();
	}



	@Override
	public int getCart(String user) {
		return orderDao.getCart(user);
	}


}
