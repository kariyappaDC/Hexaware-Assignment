package com.hexaware.hospitalmanagementsystem.service;

import java.util.List;

import com.hexaware.hospitalmanagementsystem.exception.PatientNumberNotFoundException;
import com.hexaware.hospitalmanagementsystem.dao.HospitalDao;
import com.hexaware.hospitalmanagementsystem.dao.IHospitalDao;
import com.hexaware.hospitalmanagementsystem.entity.Appointment;

public class HospitalServiceImp implements IHospitalService{
	
	private IHospitalDao dao;
	
	public HospitalServiceImp() {
		dao=new HospitalDao();
	}

	@Override
	public List<Appointment> getAppointmentById(int appointmentId) {
		
		return dao.getAppointmentById(appointmentId);
	}

	@Override
	public List<Appointment> getAppointmentsForPatient(int patientId) {
		
		return dao.getAppointmentsForPatient( patientId);
	}

	@Override
	public List<Appointment> getAppointmentsForDoctor(int doctorId) {
		
		return dao.getAppointmentsForDoctor(doctorId);
	}

	@Override
	public boolean scheduleAppointment(Appointment appointment) {
	    
		boolean schedule = dao.scheduleAppointment(appointment);
		if(schedule == false) {
			try {
				throw new PatientNumberNotFoundException();
			}catch(Exception e) {
				System.err.println("patient not found  " );
			}
		}
		return schedule;
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		
		return dao.updateAppointment( appointment);
	}

	
	@Override
	public boolean cancelAppointment(int appointmentId) {
		
		return dao.cancelAppointment(appointmentId);
	}

}
