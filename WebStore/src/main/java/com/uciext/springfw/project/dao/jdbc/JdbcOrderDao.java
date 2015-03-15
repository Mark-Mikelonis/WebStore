package com.uciext.springfw.project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.uciext.springfw.project.dao.OrderDao;
import com.uciext.springfw.project.model.Order;

public class JdbcOrderDao implements OrderDao{

	protected static Logger logger = Logger.getLogger(JdbcCatalogDao.class.getName());
	
	// SQL Statements
	private static final String SQL_INSERT_ORDER = 
				"INSERT INTO orders (order_id, order_created, total_amount, confirm_number, user) "
				+ " VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_FIND_ORDER_BY_ID = 
			"SELECT * FROM orders WHERE order_id = ?";
	private static final String SQL_FIND_ORDERS_BY_USER_ID = 
			"SELECT * FROM orders WHERE user = ?";
	private static final String SQL_FIND_ORDERS = 
			"SELECT * FROM orders";
	private static final String SQL_UPDATE_ORDER =
			"UPDATE orders SET order_created=?, total_amount=?, confirm_number=?, user=?"
			+ "WHERE order_id=?";
	private static final String SQL_DELETE_ORDER = 
			"DELETE FROM orders WHERE order_id = ?";
	
	// Datasource
	private DataSource dataSource;
		 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Override
	public Order getOrderById(int orderId) {
		logger.info("In getOrder orderId=" + orderId);
		Connection conn = null;
		Order order = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_ORDER_BY_ID);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				order = new Order(
						rs.getInt("order_id"),
						rs.getDate("order_created"),
						rs.getInt("total_amount"),
						rs.getString("confirm_number"),
						rs.getString("user")
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
		logger.info("Exiting getOrder orderId=" + orderId);
		return order;
	}

	@Override
	public void insertOrder(Order order) {
		logger.info("In insertOrder order=" + order);
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_ORDER);
			ps.setInt(1, 0);
			ps.setTimestamp(2, getCurrentJavaSqlTimestamp());
			ps.setInt(3, order.getTotalAmount());
			ps.setString(4, order.getConfirmNumber());
			ps.setString(5, order.getUser());
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
		logger.info("Exiting insertOrder orderId=" + order);
	}

	@Override
	public void updateOrder(int orderId, Order order) {
		logger.info("In updateOrder orderId=" + orderId);	
		
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_ORDER);
			ps.setTimestamp(1, getCurrentJavaSqlTimestamp());
			ps.setInt(2, order.getTotalAmount());
			ps.setString(3, order.getConfirmNumber());
			ps.setString(4, order.getUser());
			ps.setInt(5, orderId);
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
		logger.info("Exiting updateOrder orderId=" + orderId);
	
	}
	
	

	@Override
	public void deleteOrder(int orderId) {
		logger.info("In deleteOrder orderId=" + orderId);
		Connection conn = null;
		
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_ORDER);
			ps.setInt(1, orderId);
			ps.execute();
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
				
		logger.info("Exiting deleteOrder orderId=" + orderId);
	}

	@Override
	public List<Order> getProductOrdersByUser(String user) {
		logger.info("In getProductOrders");
		List<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		
		try{
			 conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(SQL_FIND_ORDERS_BY_USER_ID);
			 ps.setString(1, user);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()){
				 orders.add(new Order(
						 rs.getInt("order_id"),
						 rs.getDate("order_created"),
						 rs.getInt("total_amount"),
						 rs.getString("confirm_number"),
						 rs.getString("user")
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
		return orders;
	}
	
	@Override
	public List<Order> getProductOrders() {
		logger.info("In getProductOrders");
		List<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		
		try{
			 conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(SQL_FIND_ORDERS);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()){
				 orders.add(new Order(
						 rs.getInt("order_id"),
						 rs.getDate("order_created"),
						 rs.getInt("total_amount"),
						 rs.getString("confirm_number"),
						 rs.getString("user")
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
		return orders;
	}


	// Timestamp method
	public static java.sql.Timestamp getCurrentJavaSqlTimestamp() {
	    java.util.Date date = new java.util.Date();
	    return new java.sql.Timestamp(date.getTime());
	  }
	
	
}
