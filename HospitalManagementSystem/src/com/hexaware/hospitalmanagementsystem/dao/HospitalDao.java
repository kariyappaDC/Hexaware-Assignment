package com.hexaware.hospitalmanagementsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.hospitalmanagementsystem.entity.Appointment;

public class HospitalDao implements IHospitalDao{
	
	private Connection conn;
	public HospitalDao() {
		
		conn=DBUtil.getDBConnection();
	
	}
	

	@Override
	public List<Appointment> getAppointmentById(int appointmentId) {
		
	    List<Appointment> list = new ArrayList<Appointment>();
	    
	    String selectById = "SELECT * FROM Appointment WHERE appointmentId = ?";
	    
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(selectById);
	        pstmt.setInt(1, appointmentId); 
	        
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) { 
	           
	            int patientId = rs.getInt("patientId");
	            int doctorId = rs.getInt("doctorId");
	            Date appointmentDate = rs.getDate("appointmentDate");
	            String description = rs.getString("description");
	            
	            
	            Appointment appointement  = new Appointment(appointmentId, patientId, doctorId, appointmentDate, description);
	            list.add(appointement);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    
	    return list; 
	}

	

	@Override
	public List<Appointment> getAppointmentsForPatient(int patientId) {
	    List<Appointment> appointments = new ArrayList<>(); 
	    String selectByPatientId = "SELECT * FROM Appointment WHERE patientId = ?";

	    try  {
	    	PreparedStatement pstmt = conn.prepareStatement(selectByPatientId);
	        pstmt.setInt(1, patientId); 
	        
	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) { 
	            int appointmentId = rs.getInt("appointmentId");
	            int doctorId = rs.getInt("doctorId");
	            Date appointmentDate = rs.getDate("appointmentDate");
	            String description = rs.getString("description");
	            
	           
	            Appointment appointment = new Appointment(appointmentId, patientId, doctorId, appointmentDate, description);
	            appointments.add(appointment);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return appointments; 
	}


	
	@Override
	public List<Appointment> getAppointmentsForDoctor(int doctorId) {
	    List<Appointment> appointments = new ArrayList<>(); 
	    String selectByDoctorId = "SELECT * FROM Appointment WHERE doctorId = ?"; 

	    try  {
	    	PreparedStatement pstmt = conn.prepareStatement(selectByDoctorId);
	        pstmt.setInt(1, doctorId); 
	        
	        ResultSet rs = pstmt.executeQuery(); 
	        
	        while (rs.next()) { 
	            int appointmentId = rs.getInt("appointmentId");
	            int patientId = rs.getInt("patientId");
	            Date appointmentDate = rs.getDate("appointmentDate");
	            String description = rs.getString("description");

	            
	            Appointment appointment = new Appointment(appointmentId, patientId, doctorId, appointmentDate, description);
	            appointments.add(appointment);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return appointments; 
	}

	

	public boolean scheduleAppointment(Appointment appointment) {
	    boolean isScheduled = false; 

	    String insert = "INSERT INTO Appointment (patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?)";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(insert);
	        
	        pstmt.setInt(1, appointment.getPatientId());
	        pstmt.setInt(2, appointment.getDoctorId());
	        pstmt.setDate(3, appointment.getAppointmentDate());
	        pstmt.setString(4, appointment.getDescription());
	        
	        int count = pstmt.executeUpdate(); 
	        
	        if (count > 0) { 
	            isScheduled = true; 
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    
	    return isScheduled; 
	}

	
	@Override
	public boolean updateAppointment(Appointment appointment) {
	    boolean isUpdated = false; 

	    String updateQuery = "UPDATE Appointment SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";

	    try  {
	    	PreparedStatement pstmt = conn.prepareStatement(updateQuery);
	        pstmt.setInt(1, appointment.getPatientId()); 
	        pstmt.setInt(2, appointment.getDoctorId()); 
	        pstmt.setDate(3, appointment.getAppointmentDate()); 
	        pstmt.setString(4, appointment.getDescription()); 
	        pstmt.setInt(5, appointment.getAppointmentId());

	        int rowsAffected = pstmt.executeUpdate(); 

	        if (rowsAffected > 0) { 
	            isUpdated = true; 
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return isUpdated; 
	}

	

	@Override
	public boolean cancelAppointment(int appointmentId) {
	    boolean isCancelled = false; 

	    String deleteQuery = "DELETE FROM Appointment WHERE appointmentId = ?"; 

	    try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
	        pstmt.setInt(1, appointmentId);
	        
	        int rowsAffected = pstmt.executeUpdate(); 

	        if (rowsAffected > 0) { 
	            isCancelled = true; 
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	    
	    return isCancelled; 
	}


  
	
}
