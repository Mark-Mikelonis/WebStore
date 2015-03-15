package com.uciext.springfw.project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.uciext.springfw.project.dao.CatalogDao;
import com.uciext.springfw.project.model.Catalog;

public class JdbcCatalogDao implements CatalogDao{
	
	protected static Logger logger = Logger.getLogger(JdbcCatalogDao.class.getName());

	private static final String SQL_INSERT_CATALOG = 
			"INSERT INTO product (catalog_id, catalog_name) "
			+ " VALUES (?, ?)";
	private static final String SQL_FIND_CATALOG_BY_ID = 
			"SELECT * FROM catalog WHERE catalog_id = ?";
	private static final String SQL_FIND_ALL_CATALOGS = 
			"SELECT * FROM catalog"; 
	private static final String SQL_UPDATE_CATALOG =
			"UPDATE catalog SET catalog_id=?, catalog_name=? WHERE catalog_id=?";
	private static final String SQL_DELETE_CATALOG = 
			"DELETE FROM catalog WHERE catalog_id = ?";
	
	
	// Datasource
		private DataSource dataSource;
			 
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
	
	@Override
	public Catalog getCatalog(int catalogId) {
		logger.info("In getCatalog catalogId=" + catalogId);
		Catalog catalog = null;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareCall(SQL_FIND_CATALOG_BY_ID);
			ps.setInt(1, catalogId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				catalog = new Catalog(
						rs.getInt("catalog_id"),
						rs.getString("catalog_name")
						);
						
			}
			rs.close();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) { }
			}
		}
		logger.info("Exiting getCatalog catalogId=" + catalogId);
		return catalog;
	}
	
	@Override
	public List<Catalog> getCatalogs() {
		logger.info("In getCatalogs");
		Connection conn = null;
		List<Catalog> catalogs = new ArrayList<Catalog>();
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_ALL_CATALOGS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				catalogs.add(new Catalog(
						rs.getInt("catalog_id"),
						rs.getString("catalog_name")
						));
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (conn!=null){
				try {
					conn.close();
				} catch (SQLException e) { }
			}
		}
		logger.info("Exiting getCatalogs");
		return catalogs;
	}

	@Override
	public void insertCatalog(Catalog catalog) {
		logger.info("In insertCatalog catalog=" + catalog);
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_CATALOG);
			ps.setInt(1, catalog.getCatalogId());
			ps.setString(2, catalog.getCatalogName());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
			
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) { }
			}
		}
		
		logger.info("Exiting insertCatalog catalog=" + catalog);
	}

	@Override
	public void updateCatalog(int catalogId, Catalog catalog) {
		logger.info("In updateCatalog catalogId=" + catalogId);
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_CATALOG);
			ps.setInt(1, catalog.getCatalogId());
			ps.setString(2, catalog.getCatalogName());
			ps.setInt(3, catalogId);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
			
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) { }
			}
		}
		logger.info("Exiting updateCatalog catalogId=" + catalogId);
		
	}

	@Override
	public void deleteCatalog(int catalogId) {
		logger.info("In deleteCatalog catalogId=" + catalogId);
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_CATALOG);
			ps.setInt(1, catalogId);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (conn!=null){
				try {
					conn.close();
				} catch (SQLException e) { }
			}
		}
		
	}



}
