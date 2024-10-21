package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C , Eshwar Reddy v
 * Date: October 19, 2024
 * Description: This class implements the IProductDao interface and provides 
 * methods to manage products in the database. 
 * The methods include creating products and removing the products. It interacts with the database using JDBC.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hexaware.ecom.entity.Product;

public class ProductDaoImp implements IProductDao {

	private Connection conn;
	public ProductDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}
	
	@Override
	public boolean createPrd(Product prd) {
		int count=0;
		boolean check = false;
		
		String insert="insert into Products(product_Id,name,price,description,stockQuantity) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			
			pstmt.setInt(1, prd.getProductId());
			pstmt.setString(2, prd.getName());
			pstmt.setInt(3, prd.getPrice());
			pstmt.setString(4, prd.getDescription());
			pstmt.setInt(5, prd.getStockQuantity());
			
			count=pstmt.executeUpdate();
			if(count>0) {
				check = true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	
	@Override
	public boolean removePrd(Product prd) {
	   
	    int countProducts = 0;
	    
	    boolean check = false;
	    
	    // First delete from order_items
	    String deleteCart = "DELETE FROM cart WHERE product_id=?";
	    try {
	        PreparedStatement pstmtOrderItems = conn.prepareStatement(deleteCart);
	        pstmtOrderItems.setInt(1, prd.getProductId());
	        pstmtOrderItems.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    // First delete from order_items
	    String deleteOrderItems = "DELETE FROM order_items WHERE product_id=?";
	    try {
	        PreparedStatement pstmtOrderItems = conn.prepareStatement(deleteOrderItems);
	        pstmtOrderItems.setInt(1, prd.getProductId());
	        pstmtOrderItems.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Then delete from Products
	    String deleteProduct = "DELETE FROM Products WHERE product_Id=?";
	    try {
	        PreparedStatement pstmtProduct = conn.prepareStatement(deleteProduct);
	        pstmtProduct.setInt(1, prd.getProductId());
	        countProducts = pstmtProduct.executeUpdate();
	        
	        if (countProducts > 0) {
	        	check = true;
	        }
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	   
	    return check;
	}


	
}
