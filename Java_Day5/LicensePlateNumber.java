import java.util.regex.*;

public class LicensePlateNumber{
    public static String validateLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        if (matcher.matches()) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }

    public static void main(String[] args) {
        System.out.println(validateLicensePlate("AB1234")); 
        System.out.println(validateLicensePlate("A12345")); 
        System.out.println(validateLicensePlate("AB12")); 
        System.out.println(validateLicensePlate("XY5678")); 
        System.out.println(validateLicensePlate("ZZ9876")); 
    }
}
