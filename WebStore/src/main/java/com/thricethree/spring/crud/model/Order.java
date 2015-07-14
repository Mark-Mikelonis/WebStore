package com.thricethree.spring.crud.model;

import java.util.Date;

public class Order {

	private int orderId;
	private Date orderCreated;
	private int totalAmount;
	
	private String confirmNumber;
	private String user;
	
	public Order(){

	}
	
	public Order(int orderId, Date orderCreated, int totalAmount,
			String confirmNumber, String user) {
		this.orderId = orderId;
		this.orderCreated = orderCreated;
		this.totalAmount = totalAmount;
		this.confirmNumber = confirmNumber;
		this.user = user;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderCreated() {
		return orderCreated;
	}
	public void setOrderCreated(Date orderCreated) {
		this.orderCreated = orderCreated;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getConfirmNumber() {
		return confirmNumber;
	}
	public void setConfirmNumber(String confirmNumber) {
		this.confirmNumber = confirmNumber;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCreated=" + orderCreated
				+ ", confirmNumber=" + confirmNumber + ", user=" + user + "]";
	}
	
	
}
