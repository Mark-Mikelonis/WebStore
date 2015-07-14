package com.thricethree.spring.crud.service;


import java.util.List;

import com.thricethree.spring.crud.model.Catalog;
import com.thricethree.spring.crud.model.Product;

public interface CatalogService {

	// Catalog
	public Catalog getCatalog(int catalogId);
	public void insertCatalog(Catalog catalog);
	public void updateCatalog(int catalogId, Catalog catalog);
	public void deleteCatalog(int catalogId);
	public List<Catalog> getCatalogs();
	
	// Products
	public Product getProduct(int productId);
	public List<Product> getProducts();
	
}
