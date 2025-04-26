import java.util.*;
import java.util.regex.*;

public class ExtractingEmailAddress {
    public static List<String> extractEmailAddresses(String text) {
        List<String> emails = new ArrayList<>();
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }   
        return emails;
    }
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emailAddresses = extractEmailAddresses(text);
        for (String email : emailAddresses) {
            System.out.println(email);
        }
    }
}
