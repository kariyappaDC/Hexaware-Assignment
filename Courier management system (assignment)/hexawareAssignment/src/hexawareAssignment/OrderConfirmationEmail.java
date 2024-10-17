package hexawareAssignment;

/*12. Order Confirmation Email: Create a program that generates an order confirmation email. The email
should include details such as the customer's name, order number, delivery address, and expected
delivery date. */

public class OrderConfirmationEmail {
	
    public static String generateEmail(String customerName, String orderNumber, String deliveryAddress, String deliveryDate) {
        
        String emailContent = "Dear " + customerName + ",\n\n" +
                              "Thank you for your order!\n" +
                              "Order Number: " + orderNumber + "\n" +
                              "Delivery Address: " + deliveryAddress + "\n" +
                              "Expected Delivery Date: " + deliveryDate + "\n\n" +
                              "We appreciate your business and look forward to serving you again.\n" +
                              "Best Regards,\n" +
                              "The Courier Service Team";

        return emailContent;  
    }

    public static void main(String[] args) {
       
        String customerName = "John Doe";
        String orderNumber = "ORD123456";
        String deliveryAddress = "123 Main St, New York, NY 10001";
        String deliveryDate = "2024-10-15";

        
        String confirmationEmail = generateEmail(customerName, orderNumber, deliveryAddress, deliveryDate);
        System.out.println(confirmationEmail);
    }

}
