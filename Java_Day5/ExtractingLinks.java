import java.util.*;
import java.util.regex.*;

public class ExtractingLinks{
    public static List<String> Links(String text) {
        List<String> links = new ArrayList<>();
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9&%_./-]*)?\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }   
        return links;
    }
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> linkList = Links(text);
        for (String link : linkList) {
            System.out.print(link + ", ");
        }
    }
}
