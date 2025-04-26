import java.util.regex.*;

public class HexColourCode{
    public static String validateHexColorCode(String colorCode) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(colorCode);
        if (matcher.matches()) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }
    public static void main(String[] args) {
        System.out.println(validateHexColorCode("#FFA500")); 
        System.out.println(validateHexColorCode("#ff4500")); 
        System.out.println(validateHexColorCode("#123")); 
        System.out.println(validateHexColorCode("#ZZZZZZ")); 
        System.out.println(validateHexColorCode("#123ABC"));
    }
}
