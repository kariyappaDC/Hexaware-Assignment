package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C , Eshwar Reddy V
 * Date: October 19, 2024
 * Description: This class implements the ICartDao interface and provides 
 * methods to manage orders and order items in the database. 
 * The methods include adding to cart , removing from cart and get all the elements in the cart . It interacts with the database using JDBC.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecom.entity.Cart;

public class CartDaoImp implements ICartDao {
	
	private Connection conn;
	
	public CartDaoImp() {
		conn = DBUtil.getDBConnection();
		
	}

	@Override
	public boolean addCart(Cart car) {
		
		int count = 0;
		boolean check = false;
		
		String insert = "insert into cart values(?,?,?,?) ";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(insert);
			
			pstmt.setInt(1,car.getCartId());
			pstmt.setInt(2,car.getCustomerId());
			pstmt.setInt(3,car.getProductId());
			pstmt.setInt(4,car.getQuantity());
			
			count = pstmt.executeUpdate();
			
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
	public boolean removeCart(Cart car) {
		
        int count=0;
		boolean check = false;
		String delete="delete from Cart where cart_id=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
            pstmt.setInt(1, car.getCustomerId());
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
	public List<Cart> getAllCart() {
		
		List<Cart> list = new ArrayList<Cart>();
		
		String selectAll = "select * from cart "; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int cId = rs.getInt("cart_id");
				int cusId = rs.getInt("customer_id");
				int proId = rs.getInt("product_id");
				int qty = rs.getInt("quantity");
				
				Cart car = new Cart(cId, cusId , proId , qty);
				list.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}





}
