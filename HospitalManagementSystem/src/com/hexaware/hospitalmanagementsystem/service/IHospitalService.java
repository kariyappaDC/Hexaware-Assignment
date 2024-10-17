package com.hexaware.hospitalmanagementsystem.service;

import java.util.List;

import com.hexaware.hospitalmanagementsystem.entity.Appointment;
import com.hexaware.hospitalmanagementsystem.exception.PatientNumberNotFoundException;

public interface IHospitalService {

	    List<Appointment> getAppointmentById(int appointmentId);
	    List<Appointment> getAppointmentsForPatient(int patientId);
	    List<Appointment> getAppointmentsForDoctor(int doctorId);
	    boolean scheduleAppointment(Appointment appointment)throws PatientNumberNotFoundException;
	    boolean updateAppointment(Appointment appointment);
	    boolean cancelAppointment(int appointmentId);
	
}
