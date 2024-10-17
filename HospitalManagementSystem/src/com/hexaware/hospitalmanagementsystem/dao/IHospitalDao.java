package com.hexaware.hospitalmanagementsystem.dao;

import java.util.List;

import com.hexaware.hospitalmanagementsystem.entity.Appointment;

public interface IHospitalDao {

	 List<Appointment> getAppointmentById(int appointmentId);
	    List<Appointment> getAppointmentsForPatient(int patientId);
	    List<Appointment> getAppointmentsForDoctor(int doctorId);
	    boolean scheduleAppointment(Appointment appointment);
	    boolean updateAppointment(Appointment appointment);
	    boolean cancelAppointment(int appointmentId);
	
}
