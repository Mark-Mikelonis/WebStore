package com.thricethree.spring.crud.service.impl;

import java.util.List;

import com.thricethree.spring.crud.dao.CatalogDao;
import com.thricethree.spring.crud.dao.ProductDao;
import com.thricethree.spring.crud.model.Catalog;
import com.thricethree.spring.crud.model.Product;
import com.thricethree.spring.crud.service.CatalogService;

public class CatalogServiceImpl implements CatalogService{

	
	private CatalogDao catalogDao;
	public void setCatalogDao(CatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}

	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	
	// Catalog
	
	@Override
	public Catalog getCatalog(int catalogId) {
		return catalogDao.getCatalog(catalogId);
	}
	

	@Override
	public List<Catalog> getCatalogs() {
		return catalogDao.getCatalogs();
	}

	@Override
	public void insertCatalog(Catalog catalog) {
		catalogDao.insertCatalog(catalog);
	}

	@Override
	public void updateCatalog(int catalogId, Catalog catalog) {
		catalogDao.updateCatalog(catalogId, catalog);
		
	}

	@Override
	public void deleteCatalog(int catalogId) {
		catalogDao.deleteCatalog(catalogId);
		
	}

	// Products
	@Override
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}



}
