package com.thricethree.spring.crud.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.thricethree.spring.crud.dao.ProductOrderDao;
import com.thricethree.spring.crud.model.ProductOrder;

public class JdbcProductOrderDao implements ProductOrderDao{

	protected static Logger logger = Logger.getLogger(JdbcProductOrderDao.class
			.getName());


	// SQL Statements
	private static final String SQL_INSERT_PRODUCT_ORDER = 
			"INSERT INTO product_order (product_order_id, order_id, product_id, order_amount) "
			+ " VALUES (?, ?, ?, ?)";
	private static final String SQL_GET_PRODUCT_ORDER_BY_PRODUCT_ORDER_ID = 
			"SELECT * FROM product_order WHERE product_order_id = ? ";
	private static final String SQL_GET_PRODUCT_ORDER_BY_ORDER_ID = 
			"SELECT * FROM product_order WHERE order_id = ? ";
	private static final String SQL_UPDATE_PRODUCT_ORDER = 
			"UPDATE product_order SET product_order_id=?, order_id=?, product_id=?, order_amount=?"
			+ " WHERE product_order_id=?";
	private static final String SQL_DELETE_PRODUCT_ORDER = 
			"DELETE FROM product_order WHERE product_order_id = ? ";;
	private static final String SQL_GET_PRODUCT_ORDERS = 
			"SELECT * FROM product_order";
	
	// Datasource
	private DataSource dataSource;
			 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Override
	public void insertProductOrder(ProductOrder productOrder) {
		logger.info("In insertProductOrder");
		Connection conn = null;
	
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_PRODUCT_ORDER);
			ps.setInt(1, productOrder.getProductOrderId());
			ps.setInt(2, productOrder.getOrderId());
			ps.setInt(3, productOrder.getProductId());
			ps.setInt(4, productOrder.getOrderAmount());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) { }
			}
		}
	}

	@Override
	public ProductOrder getProductOrderByProductOrderId(int productOrderId) {
		logger.info("In getProductOrderByProductOrderId productOrderId=" + productOrderId);
		System.out.println("In getProductOrderByProductOrderId productOrderId=" + productOrderId);
		Connection conn = null;
		ProductOrder productOrder = null;
		
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_PRODUCT_ORDER_BY_PRODUCT_ORDER_ID);
			ps.setInt(1, productOrderId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				productOrder = new ProductOrder(
						rs.getInt("product_order_id"),
						rs.getInt("order_id"),
						rs.getInt("product_id"),
						rs.getInt("order_amount")
						);
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
		logger.info("Exiting getProductOrderById productOrderId=" + productOrderId);
		return productOrder;
	}


	@Override
	public List<ProductOrder> getProductOrderByOrderId(int orderId) {
		logger.info("In getProductOrderByOrderId orderId=" + orderId);
		Connection conn = null;
		List<ProductOrder> productOrders = new ArrayList<ProductOrder>();
		
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_PRODUCT_ORDER_BY_ORDER_ID);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				productOrders.add(new ProductOrder(
						rs.getInt("product_order_id"),
						rs.getInt("order_id"),
						rs.getInt("product_id"),
						rs.getInt("order_amount")
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
		logger.info("Exiting getProductOrderById productOrderId=" + orderId);
		return productOrders;
	}	

	
	@Override
	public List<ProductOrder> getProductOrders() {
		logger.info("In getProductOrders");
		Connection conn = null;
		List<ProductOrder> productOrders = new ArrayList<ProductOrder>();
		 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_GET_PRODUCT_ORDERS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				productOrders.add( new ProductOrder(
						rs.getInt("product_order_id"),
						rs.getInt("order_id"),
						rs.getInt("product_id"),
						rs.getInt("order_amount")
						) );
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
		
		
		return productOrders;
	}

	@Override
	public void updateProductOrder(int productOrderId, ProductOrder productOrder) {
		logger.info("In updateProductOrder productOrderId=" + productOrderId);
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_PRODUCT_ORDER);
			ps.setInt(1, productOrder.getProductOrderId());
			ps.setInt(2, productOrder.getOrderId());
			ps.setInt(3, productOrder.getProductId());
			ps.setInt(4, productOrder.getOrderAmount());
			ps.setInt(5, productOrderId);
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
		logger.info("Exiting updateProductOrder productOrderId=" + productOrderId);

	}

	@Override
	public void deleteProductOrder(int productOrderId) {
		logger.info("In deleteProductOrder productOrderId=" + productOrderId);
		System.out.println("In deleteProductOrder productOrderId=" + productOrderId);
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_PRODUCT_ORDER);
			ps.setInt(1, productOrderId);
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
