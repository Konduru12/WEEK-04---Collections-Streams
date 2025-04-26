import java.util.*;
import java.util.regex.*;

public class ExtractingCurrencyValues{
    public static List<String> extract(String text) {
        List<String> values = new ArrayList<>();
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }   
        return values;
    }
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> currencyValues = extract(text);
        for (String value : currencyValues) {
            System.out.print(value + ", ");
        }
    }
}
