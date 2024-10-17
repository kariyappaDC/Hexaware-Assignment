package hexawareAssignment;

/*4. Implement Courier Assignment Logic 1. Develop a mechanism to assign couriers to shipments based
on predefined criteria (e.g., proximity, load capacity) using loops.*/

public class Courier {
	


	    String name;
	    double distance;  // Distance from the shipment in kilometers
	    double maxLoad;   // Maximum load capacity in kilograms
	    double currentLoad;  // Current load of the courier

	    
	    public Courier(String name, double distance, double maxLoad, double currentLoad) {
	        this.name = name;
	        this.distance = distance;
	        this.maxLoad = maxLoad;
	        this.currentLoad = currentLoad;
	    }
	}

