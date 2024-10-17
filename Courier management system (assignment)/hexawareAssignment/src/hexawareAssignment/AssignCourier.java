package hexawareAssignment;


/*4. Implement Courier Assignment Logic 1. Develop a mechanism to assign couriers to shipments based
on predefined criteria (e.g., proximity, load capacity) using loops.*/

import java.util.Scanner;



		public class AssignCourier {

		    public static void main(String[] args) {
		        // Array of courier objects
		        Courier[] couriers = {
		            new Courier("Courier A", 2.5, 50, 20),  // 2.5 km away, max load 50kg, current load 20kg
		            new Courier("Courier B", 1.0, 40, 30),  // 1.0 km away, max load 40kg, current load 30kg
		            new Courier("Courier C", 3.0, 60, 50)   // 3.0 km away, max load 60kg, current load 50kg
		        };

		       
		        Scanner scanner = new Scanner(System.in);
		        System.out.println("Enter the parcel weight (in kg): ");
		        double parcelWeight = scanner.nextDouble();

		       
		        Courier bestCourier = null;

		        for (Courier courier : couriers) {
		            if (courier.currentLoad + parcelWeight <= courier.maxLoad) {
		                if (bestCourier == null || courier.distance < bestCourier.distance) {
		                    bestCourier = courier;  
		                }
		            }
		        }

		        
		        
		        if (bestCourier != null) {
		            System.out.println("Assigned Courier: " + bestCourier.name);
		        } else {
		            System.out.println("No couriers available to take the parcel.");
		        }

		        
		        scanner.close();
		    }


	}

	
