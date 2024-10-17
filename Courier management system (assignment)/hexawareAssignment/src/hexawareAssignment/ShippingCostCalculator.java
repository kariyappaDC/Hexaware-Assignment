package hexawareAssignment;

/*13. Calculate Shipping Costs: Develop a function that calculates the shipping cost based on the distance
between two locations and the weight of the parcel. You can use string inputs for the source and
destination addresses*/

import java.util.Scanner;


public class ShippingCostCalculator {

    public static double calculateShippingCost(double distance, double weight) {
        double costPerKm = 20;  // Cost per kilometer
        double costPerKg = 10;   // Cost per kilogram

       
        double totalCost = (distance * costPerKm) + (weight * costPerKg);
        return totalCost;  
    }

    public static void main(String[] args) {
    	
    	
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter source address: ");
        String sourceAddress = scanner.nextLine();

        System.out.print("Enter destination address: ");
        String destinationAddress = scanner.nextLine();

       
        System.out.print("Enter the distance (in kilometers): ");
        double distance = scanner.nextDouble();

        System.out.print("Enter the weight of the parcel (in kilograms): ");
        double weight = scanner.nextDouble();

      
        double shippingCost = calculateShippingCost(distance, weight);
        System.out.printf("The shipping cost from '%s' to '%s' is: ₹%.2f%n", sourceAddress, destinationAddress, shippingCost);

        
        scanner.close();
    }
	
}
