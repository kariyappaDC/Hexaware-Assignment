package hexawareAssignment;


/*8. Implement a method to find the nearest available courier for a new order using an array of couriers.*/


public class NearestCourierFinder {

    public static void main(String[] args) {
        // Create an array of couriers with their distances and availability status
        Courierb[] couriers = {
            new Courierb("Courier A", 2.5, true),  // 2.5 km away, available
            new Courierb("Courier B", 5.0, false),  // 5.0 km away, not available
            new Courierb("Courier C", 1.5, true),  // 1.5 km away, available
            new Courierb("Courier D", 3.0, true)   // 3.0 km away, available
        };

       
        Courierb nearestCourier = findNearestAvailableCourier(couriers);

        
        if (nearestCourier != null) {
            System.out.println("The nearest available courier is: " + nearestCourier.name);
        } else {
            System.out.println("No available couriers.");
        }
    }

    
    public static Courierb findNearestAvailableCourier(Courierb[] couriers) {
        Courierb nearestCourier = null;
        double shortestDistance = Double.MAX_VALUE;  // Initialize with a large number

       
        for (Courierb courier : couriers) {
            if (courier.available && courier.distance < shortestDistance) {
                nearestCourier = courier;
                shortestDistance = courier.distance;
            }
        }

        return nearestCourier;
    }
	
}
