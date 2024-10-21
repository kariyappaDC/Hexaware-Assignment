package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C , Eshwar Reddy v
 * Date: October 19, 2024
 * Description: This class implements the IOrderDao interface and provides 
 * methods to manage orders and order items in the database. 
 * The methods include adding orders, adding order items, retrieving all orders for a specific customer, 
 * and fetching the price of a product. It interacts with the database using JDBC.
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.ecom.entity.OrderItems;
import com.hexaware.ecom.entity.Orders;

public class OrderDaoImp implements IOrderDao {

	   private Connection conn;

	    
	    public OrderDaoImp() {
	        conn = DBUtil.getDBConnection();
	    }
	    
	    

		@Override
		public boolean addOrder(Orders order) {
			
	        int count = 0;
	        boolean check = false;
	        String insertOrder = "INSERT INTO orders (order_id , customer_id, order_date, total_price, shipping_address) VALUES (?, ?, ?, ?, ?)";

	        try {
	            PreparedStatement pstmt = conn.prepareStatement(insertOrder);
	            pstmt.setInt(1, order.getOrderId());
	            pstmt.setInt(2, order.getCustomerId());
	            pstmt.setDate(3, Date.valueOf(order.getOrderDate()));
	            pstmt.setDouble(4, order.getTotalPrice());
	            pstmt.setString(5, order.getShippingAddress());

	            count = pstmt.executeUpdate();
	            if (count > 0) {
	            	check = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return check;
		}

		
		
		@Override
		public boolean addOrderItems(OrderItems orderItem) {
	        int count = 0;
	        boolean check = false;
	        String insertOrderItem = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

	        try {
	            PreparedStatement pstmt = conn.prepareStatement(insertOrderItem);
	            pstmt.setInt(1, orderItem.getOrderId());
	            pstmt.setInt(2, orderItem.getProductId());
	            pstmt.setInt(3, orderItem.getQuantity());

	            count = pstmt.executeUpdate();
	            
	            count = pstmt.executeUpdate();
	            if (count > 0) {
	            	check = true;
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return check;
		}



		@Override
		public List<Orders> getAllOrders(int customerId) {
			 
			List<Orders> list = new ArrayList<Orders>();
			
			String selectAll = "select * from orders where customer_id = ? "; 
			try {
				PreparedStatement pstmt = conn.prepareStatement(selectAll);
				
		        pstmt.setInt(1, customerId);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					int oId = rs.getInt("order_id");
					int cusId = rs.getInt("customer_id");
					LocalDate orderDate = rs.getDate("order_date").toLocalDate();
		            double totalPrice = rs.getDouble("total_price"); 
		            String shippingAddress = rs.getString("shipping_address");
					Orders order = new Orders(oId, cusId , orderDate , totalPrice,shippingAddress);
					list.add(order);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
			
		}


//to get the price so  that i can multiply 
		@Override
		public double getProductPrice(int productId) {
		    double price = 0.0;
		    String query = "SELECT price FROM products WHERE product_id = ?";

		    try {
		        PreparedStatement pstmt = conn.prepareStatement(query);
		        pstmt.setInt(1, productId);
		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {
		            price = rs.getDouble("price");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return price;
		}

	    
	    
	
}
