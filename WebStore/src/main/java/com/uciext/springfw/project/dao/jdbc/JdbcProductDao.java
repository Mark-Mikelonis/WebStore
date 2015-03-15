package com.uciext.springfw.project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.uciext.springfw.project.dao.ProductDao;
import com.uciext.springfw.project.model.Product;

public class JdbcProductDao implements ProductDao{
 
	protected static Logger logger = Logger.getLogger(JdbcProductDao.class.getName());
	
	// SQL Statements
	private static final String SQL_INSERT_PRODUCT = 
			"INSERT INTO product (product_id, catalog_id, sku, product_name, available_quantity, uom) "
			+ " VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_FIND_PRODUCT_BY_ID = 
			"SELECT * FROM product WHERE product_id = ?"; 
	private static final String SQL_UPDATE_PRODUCT =
			"UPDATE product SET product_id=?, catalog_id=?, sku=?, product_name=?, available_quantity=?, uom=?"
			+ " WHERE product_id=?";
	private static final String SQL_DELETE_PRODUCT = 
			"DELETE FROM product WHERE product_id = ?";
	private static final String SQL_FIND_PRODUCTS_USER = 
			"SELECT * FROM product WHERE available_quantity > 0";
	private static final String SQL_FIND_PRODUCTS_ADMIN = 
			"SELECT * FROM product";
	private static final String SQL_FIND_PRODUCTS_BY_CATAOLG = 
			"SELECT * FROM product WHERE catalog_id = ?";

	// Datasource
	private DataSource dataSource;
		 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// DB Methods
	@Override
	public void insertProduct(Product product) {
		logger.info("In insertProduct product=" + product);
		
		Connection conn = null;
		 
		try {

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_PRODUCT);
			ps.setInt(1, 0);
			ps.setInt(2, product.getCatalogId());
			ps.setString(3, product.getSku());
			ps.setString(4, product.getProductName());
			ps.setInt(5, product.getAvailableQuantity());
			ps.setString(6, product.getUnitOfMeasure());
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
	@Override
	public Product getProduct(int productId) {
		logger.info("In getProduct productId=" + productId);
		
		Connection conn = null;
		Product product = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCT_BY_ID);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				product = new Product(
						rs.getInt("product_id"),
						rs.getInt("catalog_id"),
						rs.getString("sku"),
						rs.getString("product_name"),
						rs.getInt("available_quantity"),
						rs.getString("uom")
						);
			}
			rs.close();
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
		logger.info("Exit getProduct product=" + product);
		return product;
	}

	@Override
	public void updateProduct(int productId, Product product) {
		
		logger.info("In updateProduct productId=" + productId);
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_PRODUCT);
			ps.setInt(1, product.getProductId());
			ps.setInt(2, product.getCatalogId());
			ps.setString(3, product.getSku());
			ps.setString(4, product.getProductName());
			ps.setInt(5, product.getAvailableQuantity());
			ps.setString(6, product.getUnitOfMeasure());
			ps.setInt(7, productId);
			ps.executeUpdate();
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
		logger.info("Exiting updateProduct productId=" + productId);
	}

	@Override
	public void deleteProduct(int productId) {
		logger.info("In deleteProduct productId=" + productId);
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_PRODUCT);
			ps.setInt(1, productId);
			ps.executeUpdate();
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
		logger.info("Exiting deleteProduct productId=" + productId);
	}

	@Override
	// Get products method for user
	public List<Product> getProducts() {
		logger.info("In getProducts");
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCTS_USER);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				products.add(new Product(
						rs.getInt("product_id"),
						rs.getInt("catalog_id"),
						rs.getString("sku"),
						rs.getString("product_name"),
						rs.getInt("available_quantity"),
						rs.getString("uom")
						) );
			}
			rs.close();
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
		logger.info("Exiting getProducts");
		return products;
	}
	
	@Override
	// Get products method for Admin
	public List<Product> getProductsAdmin() {
		logger.info("In getProductsAdmin");
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCTS_ADMIN);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				products.add(new Product(
						rs.getInt("product_id"),
						rs.getInt("catalog_id"),
						rs.getString("sku"),
						rs.getString("product_name"),
						rs.getInt("available_quantity"),
						rs.getString("uom")
						) );
			}
			rs.close();
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
		logger.info("Exiting getProductsAdmin");
		return products;
	}

	
	public List<Product> getProductsByCatalogId(int catalogId) {
		logger.info("In getProductsByCatalogId catalogId=" + catalogId);
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCTS_BY_CATAOLG);
			ps.setInt(1, catalogId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				products.add(new Product(
						rs.getInt("product_id"),
						rs.getInt("catalog_id"),
						rs.getString("sku"),
						rs.getString("product_name"),
						rs.getInt("available_quantity"),
						rs.getString("uom")
						) );
			}
			rs.close();
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
		logger.info("Exiting getProductsByCatalogId catalogId=" + catalogId);
		return products;
	}

	


}
