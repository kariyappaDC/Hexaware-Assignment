package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C , Eshwar Reddy V
 * Date: October 19, 2024
 * Description: This class implements the IOrderDao interface and provides 
 * methods to manage orders and order items in the database. 
 * The methods include adding customer and removing the customer. It interacts with the database using JDBC.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hexaware.ecom.entity.Customer;

public  class CustomerDaoImp implements ICustomerDao{
	
	private Connection conn;
	public CustomerDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}
	
	@Override
	public boolean createCst(Customer cst) {
		
		int  count=0;
		boolean check = false;
		
		String insert="insert into Customers(customer_Id,name,email,password) values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			
			pstmt.setInt(1, cst.getCustomerId());
			pstmt.setString(2, cst.getName());
			pstmt.setString(3, cst.getEmail());
			pstmt.setString(4, cst.getPassword());
			
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
	public boolean removeCst(Customer cst) {
		int count=0;
		boolean check = false;
		
		String delete="delete from Customer where customerId=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
			
			pstmt.setInt(1, cst.getCustomerId());
			
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

}
