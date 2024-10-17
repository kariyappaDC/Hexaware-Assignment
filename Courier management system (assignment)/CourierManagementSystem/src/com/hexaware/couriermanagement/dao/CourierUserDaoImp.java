package com.hexaware.couriermanagement.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.couriermanagement.entity.Courier;


public class CourierUserDaoImp implements ICourierUserDao {
	
	private Connection conn;
	
	public CourierUserDaoImp() {
		conn = DBUtil.getDBConnection();
		
	}

	@Override
	public int placeOrder(Courier cr) {
		int randomNumber=1000;
	    int trackingNumber= ++randomNumber;  

	    String insert = "INSERT INTO courier (senderName, senderAddress, receiverName, receiverAddress, weight, status, trackingNumber , deliveryDate, userID, employeeID) VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

	        pstmt.setString(1, cr.getSenderName());
	        pstmt.setString(2, cr.getSenderAddress());
	        pstmt.setString(3, cr.getReceiverName());
	        pstmt.setString(4, cr.getReceiverAddress());
	        pstmt.setDouble(5, cr.getWeight());
	        pstmt.setString(6, cr.getStatus());
	        pstmt.setInt(7, cr.getTrackingNumber()); 
	        pstmt.setDate(8, cr.getDeliveryDate());
	        pstmt.setInt(9, cr.getUserID());
	        pstmt.setInt(10, cr.getEmployeeID());

	        
	        pstmt.executeUpdate();

	        
	        ResultSet rs = pstmt.getGeneratedKeys();
	        if (rs.next()) {
	            trackingNumber = rs.getInt(1);  
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return trackingNumber;  
	}



	
	@Override
	public String getOrderStatus(int trackingNumber) {

	    String status = null;

	    String query = "SELECT status FROM courier WHERE trackingNumber = ?";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, trackingNumber);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            status = rs.getString("status");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return status;
	}


	@Override
	public boolean cancelOrder(int trackingNumber) {

	    boolean isCanceled = false;

	    String query = "UPDATE courier SET status = 'Canceled' WHERE trackingNumber = ?";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, trackingNumber);

	        int rowsAffected = pstmt.executeUpdate();

	        
	        if (rowsAffected > 0) {
	            isCanceled = true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isCanceled;
	}
	

	@Override
	public List<Courier> getAssignedOrder(int employeeID) {
	    List<Courier> assignedOrders = new ArrayList<>();
	    
	    try {
	        String query = "SELECT * FROM courier WHERE employeeID = ?";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, employeeID);
	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            Courier order = new Courier();
	            order.setCourierID(rs.getInt("courierID"));  
	            order.setSenderName(rs.getString("senderName"));
	            order.setReceiverName(rs.getString("receiverName"));
	            order.setWeight(rs.getDouble("weight"));
	            order.setStatus(rs.getString("status"));
	            assignedOrders.add(order);  
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return assignedOrders;  
	}








}
