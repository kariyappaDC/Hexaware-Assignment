package hexawareAssignment;


import java.util.Scanner;

/*1. Write a program that checks whether a given order is delivered or not based on its status (e.g.,
"Processing," "Delivered," "Cancelled"). Use if-else statements for this. */

public class OrderStatusChecker {
	public static void main(String args[]) {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the status of the order (Processing, Delivered, Cancelled):");
		String orderStatus = scanner.nextLine();
		
		if(orderStatus.equalsIgnoreCase("Delivered")) {
			System.out.println("The order has been delivered.");
		}else if(orderStatus.equalsIgnoreCase("Processsing")) {
			System.out.println("The order is still processing...");
		}else if(orderStatus.equalsIgnoreCase("Cancelled")) {
			System.out.println("The order has been cancelled.");
		}else {
			System.out.println("Invalid order status has been enterd .");
		}
		
		scanner.close();
		
	}
}
