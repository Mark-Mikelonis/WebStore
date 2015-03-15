package com.uciext.springfw.project.model;

public class ProductOrder {

	private int productOrderId;
	private int orderAmount;
	
	private int orderId;
	private int productId;
	
	public ProductOrder(){
		
	}
	
	public ProductOrder(int productOrderId, int orderAmount, int orderId,
			int productId) {
		this.productOrderId = productOrderId;
		this.orderAmount = orderAmount;
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(int productOrderId) {
		this.productOrderId = productOrderId;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductOrder [productOrderId=" + productOrderId
				+ ", orderAmount=" + orderAmount + ", orderId=" + orderId
				+ ", productId=" + productId + "]";
	}

	
	
}
