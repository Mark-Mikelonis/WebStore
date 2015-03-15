package com.uciext.springfw.project.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.uciext.springfw.project.dao.CatalogDao;
import com.uciext.springfw.project.dao.ProductDao;
import com.uciext.springfw.project.model.Catalog;
import com.uciext.springfw.project.model.Product;
import com.uciext.springfw.project.service.CatalogService;

public class CatalogServiceImpl implements CatalogService{

	private static Logger logger = Logger.getLogger(CatalogServiceImpl.class.getName());
	
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
