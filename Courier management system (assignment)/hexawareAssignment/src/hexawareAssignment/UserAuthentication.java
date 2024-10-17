package hexawareAssignment;

import java.util.Scanner;

/*3. Implement User Authentication 1. Create a login system for employees and customers using Java
control flow statements. 
*/

public class UserAuthentication {
	
	public static void main(String args[]) {
		
	      
        String employeeUsername = "abc";
        String employeePassword = "abc123";

     
        String customerUsername = "cus";
        String customerPassword = "cus123";

       
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Welcome to the Courier Management System.");
        System.out.println("Please login.");
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        
        if (username.equals(employeeUsername) && password.equals(employeePassword)) {
            System.out.println("Login successful! Welcome, Employee.");
        } else if (username.equals(customerUsername) && password.equals(customerPassword)) {
            System.out.println("Login successful! Welcome, Customer.");
        } else {
            System.out.println("Login failed! Invalid username or password.");
        }

        
        scanner.close();
    }
		
	

}
