package com.thricethree.spring.crud.dao;

import java.util.List;

import com.thricethree.spring.crud.model.Catalog;

public interface CatalogDao {

		public Catalog getCatalog(int catalogId);
		public void insertCatalog(Catalog catalog);
		public void updateCatalog(int catalogId, Catalog catalog);
		public void deleteCatalog(int catalogId);
		public List<Catalog> getCatalogs();
}
