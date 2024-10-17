package hexawareAssignment;

/*10. Customer Data Validation: Write a function which takes 2 parameters, data-denotes the data and
detail-denotes if it is name addtress or phone number.Validate customer information based on
following critirea. Ensure that names contain only letters and are properly capitalized, addresses do not
contain special characters, and phone numbers follow a specific format (e.g., ###-###-####). */

public class CustomerValidation {
	
    public static boolean validateData(String data, String detail) {
        switch (detail.toLowerCase()) {
            case "name":
                // Name validation: only letters, properly capitalized (first letter uppercase)
                return data.matches("[A-Z][a-zA-Z]*");
            
            case "address":
                // Address validation: no special characters (only letters, numbers, and spaces allowed)
                return data.matches("[A-Za-z0-9\\s]*");
            
            case "phone number":
                // Phone number validation: must follow ###-###-####
                return data.matches("\\d{3}-\\d{3}-\\d{4}");
            
            default:
                // Invalid detail type
                System.out.println("Invalid data type. Please enter 'name', 'address', or 'phone number'.");
                return false;
        }
    }

    public static void main(String[] args) {
    

        
        String name = "John8Doe";
        String address = "123 Main St";
        String phone = "123-456-7890";

        
        System.out.println("Name valid: " + validateData(name, "name"));        // false
        System.out.println("Address valid: " + validateData(address, "address")); // true
        System.out.println("Phone valid: " + validateData(phone, "phone number")); // true

        
        String validName = "John";
        System.out.println("Valid name: " + validateData(validName, "name"));    // true
    }

}
