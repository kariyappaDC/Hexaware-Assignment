package hexawareAssignment;

/*9. Parcel Tracking: Create a program that allows users to input a parcel tracking number.Store the
tracking number and Status in 2d String Array. Initialize the array with values. Then, simulate the
tracking process by displaying messages like "Parcel in transit," "Parcel out for delivery," or "Parcel
delivered" based on the tracking number's status. */

public class ParcelTracking2D {
	
    public static void main(String[] args) {
   
        String[][] trackingData = {
            {"123456", "In Transit"},
            {"789012", "Out for Delivery"},
            {"345678", "Delivered"}
        };

       
        String trackingNumber = "123456"; 

        
        boolean found = false;
        for (String[] tracking : trackingData) {
            if (tracking[0].equals(trackingNumber)) {
                System.out.println("Tracking Number: " + tracking[0] + " - Status: " + tracking[1]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Tracking number not found.");
        }
    }

}
