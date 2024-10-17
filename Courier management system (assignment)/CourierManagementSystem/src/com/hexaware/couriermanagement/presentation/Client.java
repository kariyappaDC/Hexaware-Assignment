package com.hexaware.couriermanagement.presentation;

import com.hexaware.couriermanagement.entity.Courier;
import com.hexaware.couriermanagement.entity.Employee;
import com.hexaware.couriermanagement.exception.InvalidEmployeeIdException;
import com.hexaware.couriermanagement.exception.TrackingNumberNotFoundException;
import com.hexaware.couriermanagement.service.CourierAdminServiceImp;
import com.hexaware.couriermanagement.service.ICourierAdminService;
import com.hexaware.couriermanagement.service.ICourierUserService;
import com.hexaware.couriermanagement.service.CourierUserServiceImp;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICourierUserService courierService = new CourierUserServiceImp();
        ICourierAdminService courierAdminService = new CourierAdminServiceImp();
        int choice;

        do {
            System.out.println("*** Courier Service Menu ***");
            System.out.println("1. Place a New Courier Order");
            System.out.println("2. Get Order Status");
            System.out.println("3. Cancel an Order");
            System.out.println("4. Get Assigned Orders for Courier Staff");
            System.out.println("5. Add Staff Member To The System");
            System.out.println("6. Get Employee Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Courier courierObj = new Courier();

                    // Input fields from user
                    System.out.println("Enter the Sender Name:");
                    courierObj.setSenderName(scanner.nextLine());

                    System.out.println("Enter the Sender Address:");
                    courierObj.setSenderAddress(scanner.nextLine());

                    System.out.println("Enter the Receiver Name:");
                    courierObj.setReceiverName(scanner.nextLine());

                    System.out.println("Enter the Receiver Address:");
                    courierObj.setReceiverAddress(scanner.nextLine());

                    System.out.println("Enter the Weight of the Package:");
                    courierObj.setWeight(scanner.nextDouble());

                    System.out.println("Enter the User ID:");
                    courierObj.setUserID(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Enter the Employee ID:");
                    courierObj.setEmployeeID(scanner.nextInt());
                    scanner.nextLine();

                    
                    courierObj.setStatus("Pending");
                    courierObj.setDeliveryDate(Date.valueOf(LocalDate.now().plusDays(3)));  

                    
                    int count = courierService.placeOrder(courierObj);
                    if (count > 0) {
                        System.out.println("New courier order has been placed");
                    } else {
                        System.err.println("Failed to place the order");
                    }
                    break;

                case 2:
                    System.out.println("Enter Tracking Number: ");
                    int trackingNumberStatus = scanner.nextInt();
                    
                    try {
                        String status = courierService.getOrderStatus(trackingNumberStatus);
                        System.out.println("Order Status: " + status);
                    } catch (TrackingNumberNotFoundException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Enter Tracking Number of the Order to Cancel: ");
                    int trackingNumberCancel = scanner.nextInt();
                    
                    try {
                        boolean result = courierService.cancelOrder(trackingNumberCancel);
                        if (result) {
                            System.out.println("Order canceled successfully.");
                        } else {
                            System.out.println("Failed to cancel the order.");
                        }
                    } catch (TrackingNumberNotFoundException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Enter courier staff ID:");
                    int courierStaffId = scanner.nextInt();
                    
                    try {
                        List<Courier> assignedOrders = courierService.getAssignedOrder(courierStaffId);
                        if (assignedOrders.isEmpty()) {
                            System.out.println("No orders found for courier staff ID: " + courierStaffId);
                        } else {
                            System.out.println("Assigned orders for courier staff ID: " + courierStaffId);
                            for (Courier order : assignedOrders) {
                                System.out.println(order);
                            }
                        }
                    } catch (InvalidEmployeeIdException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    Employee employeeObj = new Employee();

                    System.out.println("Enter the Employee Name:");
                    employeeObj.setEmployeeName(scanner.nextLine());

                    System.out.println("Enter the Employee Email:");
                    employeeObj.setEmail(scanner.nextLine());

                    System.out.println("Enter the Employee Contact Number:");
                    employeeObj.setContactNumber(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Enter the Employee Role:");
                    employeeObj.setRole(scanner.nextLine());

                    System.out.println("Enter the Employee Salary:");
                    employeeObj.setSalary(scanner.nextDouble());
                    scanner.nextLine();

                    int countAdmin = courierAdminService.addCourierStaff(employeeObj);
                    if (countAdmin > 0) {
                        System.out.println("New courier staff member has been added.");
                    } else {
                        System.err.println("Failed to add staff member.");
                    }
                    break;

                case 6:
                    System.out.println("Enter Employee ID to Search Employee:");
                    int eid = scanner.nextInt();
                    Employee employee = courierAdminService.getByEid(eid);
                    if (employee != null) {
                        System.out.println(employee);
                    } else {
                        System.out.println("Employee not found for ID: " + eid);
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
