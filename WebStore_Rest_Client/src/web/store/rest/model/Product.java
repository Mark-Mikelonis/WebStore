package web.store.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

	private int productId;
	private int catalogId;
	private String sku;
	private String productName;
	private int availableQuantity;
	private String unitOfMeasure;
	
	
	
	public Product(){
		
	}
		


	public Product(int productId, int catalogId, String sku,
			String productName, int availableQuantity, String unitOfMeasure) {
		this.productId = productId;
		this.catalogId = catalogId;
		this.sku = sku;
		this.productName = productName;
		this.availableQuantity = availableQuantity;
		this.unitOfMeasure = unitOfMeasure;
	}



	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", catalogId=" + catalogId
				+ ", availableQuantity=" + availableQuantity + ", sku=" + sku
				+ ", productName=" + productName + ", unitOfMeasure="
				+ unitOfMeasure + "]";
	}
}
