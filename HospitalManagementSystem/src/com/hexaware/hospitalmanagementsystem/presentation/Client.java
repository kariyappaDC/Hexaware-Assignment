package com.hexaware.hospitalmanagementsystem.presentation;

import com.hexaware.hospitalmanagementsystem.service.IHospitalService;
import com.hexaware.hospitalmanagementsystem.entity.Appointment;
import com.hexaware.hospitalmanagementsystem.service.HospitalServiceImp;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Client {

	public static void main(String  args[]) {
		
		 IHospitalService service = new HospitalServiceImp();
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("**************** Hospital Management System *******************");
	            System.out.println("1. Get Appointment By ID");
	            System.out.println("2. Get Appointments for Patient");
	            System.out.println("3. Get Appointments for Doctor");
	            System.out.println("4. Schedule Appointment");
	            System.out.println("5. Update Appointment");
	            System.out.println("6. Cancel Appointment");
	            System.out.println("7. Exit");
	            System.out.print("Enter your choice ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                	  System.out.print("Enter Appointment ID ");
	                	    int appointmentId = scanner.nextInt();
	                	    List<Appointment> appoList = service.getAppointmentById(appointmentId);
	                	    
	                	    if (appoList.isEmpty()) { 
	                	        System.out.println("Appointment not found for : " + appointmentId);
	                	    } else {
	                	    	 for (Appointment  orderCus : appoList) {
	                     	        System.out.println(orderCus);
	                     	    }
	                	    }
	                	    break;
	                	    

	                case 2:
	                	
	                    System.out.print("Enter Patient ID ");
	                    int patientId = scanner.nextInt(); 
	                    List<Appointment> patientAppoList = service.getAppointmentsForPatient(patientId); 

	                    
	                    if (patientAppoList.isEmpty()) { 
	                        System.out.println("no appointments found for patient " + patientId);
	                    } else {
	                        for (Appointment appointment : patientAppoList) {
	                            System.out.println(appointment); 
	                        }
	                    }
	                    break;

	                case 3:
	                   
	                	
	                    System.out.print("Enter doctor id");
	                    int doctorId = scanner.nextInt(); 
	                    List<Appointment> doctorAppoList = service.getAppointmentsForDoctor(doctorId); 

	                    
	                    if (doctorAppoList.isEmpty()) { 
	                        System.out.println("no appointments found for doctor id: " + doctorId);
	                    } else {
	                        
	                        for (Appointment appointment : doctorAppoList) {
	                            System.out.println(appointment); 
	                        }
	                    }
	                	
	                    break;

	                case 4:
	                
	                    System.out.println("Schedule Appointment");

	                    System.out.print("Enter Patient ID ");
	                    int apPatientId = scanner.nextInt();

	                    
	                    System.out.print("Enter Doctor ID ");
	                    int apDoctorId = scanner.nextInt();

	                    
	                    System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
	                    String dateInput = scanner.next(); 
	                    Date apAppointmentDate = Date.valueOf(dateInput); 

	                    
	                    System.out.print("Enter Description: ");
	                    String apDescription = scanner.next();

	                    
	                    Appointment newAppointment = new Appointment(0, apPatientId, apDoctorId, apAppointmentDate,apDescription);

	                    
	                    boolean isScheduled = service.scheduleAppointment(newAppointment);

	                    
	                    if (isScheduled) {
	                        System.out.println("Appointment scheduled successfully");
	                    } else {
	                        System.out.println("Failed to schedule appointment. Please try again");
	                    }
	                    break;


	                case 5:
	                
	                    System.out.print("enter appointment id to update ");
	                    int newAppointmentId = scanner.nextInt();

	                   
	                    System.out.print("Enter new patient id ");
	                    int newPatientId = scanner.nextInt();

	                    
	                    System.out.print("enter new doctor id ");
	                    int newDoctorId = scanner.nextInt();

	                    
	                    System.out.print("enter new appointment Date (YYYY-MM-DD): ");
	                    String newDateInput = scanner.next(); 
	                    Date newAppointmentDate = Date.valueOf(newDateInput); 

	                    
	                    System.out.print("enter new description ");
	                    String newDescription = scanner.next();

	                    
	                    Appointment updatedAppointment = new Appointment(newAppointmentId, newPatientId, newDoctorId, newAppointmentDate, newDescription);

	                   
	                    boolean isUpdated = service.updateAppointment(updatedAppointment);

	                    
	                    if (isUpdated) {
	                        System.out.println("Appointment updated successfully");
	                    } else {
	                        System.out.println("Failed to update appointment. Please try again");
	                    }
	                    
	                	
	                    break;

	                case 6:
	                  
	                    System.out.println("cancel appointment");

	                    
	                    System.out.print("Enter Appointment ID to Cancel ");
	                    int cancelAppointmentId = scanner.nextInt(); 

	                    
	                    boolean isCancelled = service.cancelAppointment(cancelAppointmentId);

	                    
	                    if (isCancelled) {
	                        System.out.println("Appointment cancelled successfully");
	                    } else {
	                        System.out.println("Failed to cancel appointment. It may not exist");
	                    }
	                    break;

	                

	                case 7:
	                	
	                    System.out.println("THANK YOU.");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 7);

	        scanner.close(); 
		
	}
	
}
