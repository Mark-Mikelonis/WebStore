package com.uciext.springfw.project.dao;

import java.util.List;

import com.uciext.springfw.project.model.Catalog;

public interface CatalogDao {

		public Catalog getCatalog(int catalogId);
		public void insertCatalog(Catalog catalog);
		public void updateCatalog(int catalogId, Catalog catalog);
		public void deleteCatalog(int catalogId);
		public List<Catalog> getCatalogs();
}
