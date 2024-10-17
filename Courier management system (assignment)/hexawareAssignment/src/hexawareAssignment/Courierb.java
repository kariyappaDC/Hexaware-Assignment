package hexawareAssignment;

/*8. Implement a method to find the nearest available courier for a new order using an array of couriers.*/

public class Courierb {
	
	  String name;
	  double distance;  // Distance from the new order in kilometers
	  boolean available;  // Courier availability status

	    
	    public Courierb(String name, double distance, boolean available) {
	        this.name = name;
	        this.distance = distance;
	        this.available = available;
	    }

}
