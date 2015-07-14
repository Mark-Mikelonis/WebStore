package com.thricethree.spring.crud.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="productOrderList")
public class ProductOrderList {
	
	ArrayList<ProductOrder> productOrder = new ArrayList<ProductOrder>();

	public ArrayList<ProductOrder> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(ArrayList<ProductOrder> productOrder) {
		this.productOrder = productOrder;
	}
	
}





