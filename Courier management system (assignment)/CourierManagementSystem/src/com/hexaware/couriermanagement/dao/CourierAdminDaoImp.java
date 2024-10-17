package com.hexaware.couriermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.couriermanagement.entity.Employee;

public class CourierAdminDaoImp implements ICourierAdminDao {
	
	
	private Connection conn;
	
	public CourierAdminDaoImp() {
		conn = DBUtil.getDBConnection();
		
	}

	@Override
	public int addCourierStaff(Employee employee) {
	    int count = 0; 
	    
	    String insert = "INSERT INTO employee ( employeeName,email,contact_number, role, salary) VALUES ( ?, ? ,?, ?, ?)";

	    try {
	        
	        PreparedStatement pstmt = conn.prepareStatement(insert);
	        
	        
	        
	        pstmt.setString(1, employee.getEmployeeName());
	        pstmt.setString(2, employee.getEmail());
	        pstmt.setInt(3, employee.getContactNumber());
	        pstmt.setString(4, employee.getRole());
	        pstmt.setDouble(5, employee.getSalary());
	        
	        

	        
	        
	        count = pstmt.executeUpdate();
	     

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return count; 
	}
	
	@Override
	public Employee getByEid(int eid) {

		String selectOne = "select * from Employees where eid = ?";
		
		PreparedStatement pstmt;

		Employee emp = null;
		try {
			pstmt = conn.prepareStatement(selectOne);

					pstmt.setInt(1, eid);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int empId = rs.getInt("eid");
				String ename = rs.getString("ename");
				String email = rs.getString("email");
				int contact = rs.getInt("contact");
				String role = rs.getString("role");
				double salary = rs.getDouble("salary");
				

				emp = new Employee(empId, ename,email,contact,role,salary);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
		
	}

}
