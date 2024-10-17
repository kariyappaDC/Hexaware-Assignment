package hexawareAssignment;

/*5. Write a Java program that uses a for loop to display all the orders for a specific customer.*/

import java.util.Scanner;

public class OrderDisplay {

	public static void main(String[] args) {
		
        // Sample orders array
        Order[] orders = {
            new Order(1, 101, "Electronics"),
            new Order(2, 102, "Books"),
            new Order(3, 101, "Clothing"),
            new Order(4, 103, "Electronics"),
            new Order(5, 102, " Accessories")
        };

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer ID to display orders: ");
        int customerId = scanner.nextInt();

     
        System.out.println("Orders for customer ID " + customerId + ":");
        boolean foundOrders = false;

        for (Order order : orders) {
            if (order.customerId == customerId) {
                System.out.println(order.orderDetails);
                foundOrders = true;  // Mark that at least one order was found
            }
        }

       
        if (!foundOrders) {
            System.out.println("No orders found for this customer.");
        }

        
        scanner.close();
    }
	
}
