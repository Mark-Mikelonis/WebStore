package com.thricethree.spring.crud.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductOrder {

	private int productOrderId;
	private int orderId;
	private int productId;
	private int orderAmount;
	private String productName;
	
	public ProductOrder(){
		
	}
	
	public ProductOrder(int productOrderId, int orderId, 
			int productId, int orderAmount) {
		this.productOrderId = productOrderId;
		this.orderId = orderId;
		this.productId = productId;
		this.orderAmount = orderAmount;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductOrder [productOrderId=" + productOrderId + ", orderId="
				+ orderId + ", productId=" + productId + ", orderAmount="
				+ orderAmount + ", productName=" + productName + "]";
	}


	

	
	
}
