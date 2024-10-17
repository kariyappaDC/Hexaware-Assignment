package hexawareAssignment;

/*7. Create an array to store the tracking history of a parcel, where each entry represents a location
update*/

public class ParcelTracking {
	
	
	public static void main(String[] args) {
        
        String[] trackingHistory = new String[5]; 

        
        trackingHistory[0] = "Dispatched from Warehouse";
        trackingHistory[1] = "Arrived at Sorting Center";
        trackingHistory[2] = "Departed from Sorting Center";
        trackingHistory[3] = "In Transit to Destination";
        trackingHistory[4] = "Delivered";

        
        System.out.println("Parcel Tracking History:");
        for (int i = 0; i < trackingHistory.length; i++) {
            System.out.println("Location " + (i + 1) + ": " + trackingHistory[i]);
        }
    }

}
