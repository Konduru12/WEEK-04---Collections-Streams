import java.util.*;
import java.util.regex.*;

public class ExtractingProgrammingLang{
    public static List<String> extract(String text) {
        List<String> languages = new ArrayList<>();
        String regex = "\\b[A-Z][a-zA-Z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }   
        return languages;
    }
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languageList = extract(text);   
        for (String lang : languageList) {
            System.out.print(lang + ", ");
        }
    }
}
