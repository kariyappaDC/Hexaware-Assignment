package hexawareAssignment;

/*5. Write a Java program that uses a for loop to display all the orders for a specific customer.*/

public class Order {
	
	    int orderId;
	    int customerId; 
	    String orderDetails;

	    
	    public Order(int orderId, int customerId, String orderDetails) {
	        this.orderId = orderId;
	        this.customerId = customerId;
	        this.orderDetails = orderDetails;
	    }

}
