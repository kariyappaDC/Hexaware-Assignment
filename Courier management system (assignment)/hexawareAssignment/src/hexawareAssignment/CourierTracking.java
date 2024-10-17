package hexawareAssignment;

/*6. Implement a while loop to track the real-time location of a courier until it reaches its destination*/

import java.util.Random;

public class CourierTracking {

	
	public static void main(String[] args) {
       
        double courierLocation = 50.0;  
        double destination = 0.0;       

        Random random = new Random();  

        
        while (courierLocation > destination) {
           
            System.out.printf("Courier is %.2f km away from the destination.\n", courierLocation);

            // Move the courier a random distance between 1 and 5 km closer to the destination
            double moveDistance = 1 + random.nextDouble() * 4;  
            courierLocation -= moveDistance;  // Update courier's location

            // Prevent the location from going below the destination (0 km)
            if (courierLocation < destination) {
                courierLocation = destination;
            }
        }

        
        System.out.println("Courier has reached the destination.");
    }
}
