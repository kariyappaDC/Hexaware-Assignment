package hexawareAssignment;

import java.util.Scanner;

/*2. Implement a switch-case statement to categorize parcels based on their weight into "Light,"
"Medium," or "Heavy." */


public class ParcelCategorizer {
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter the weight of the parcel");
		double weight = scanner.nextDouble();
		
		
		int weightCategory = 0;
		
		if (weight > 0 && weight <= 2) {
			 weightCategory = 1;
		}else if(weight > 2 && weight <= 4) {
			 weightCategory = 2; 
		}else if(weight > 4) {
			 weightCategory = 3;
		}
		

        switch (weightCategory) {
            case 1:
                System.out.println("The parcel is categorized as 'Light'.");
                break;
            case 2:
                System.out.println("The parcel is categorized as 'Medium'.");
                break;
            case 3:
                System.out.println("The parcel is categorized as 'Heavy'.");
                break;
            default:
                System.out.println("Invalid weight or the parcel has an invalid weight.");
        }
		
        scanner.close();
		
	}

}
