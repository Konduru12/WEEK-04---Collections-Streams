import java.util.*;
import java.util.regex.*;

public class CapitalizedWords {
    public static List<String> extractCapitalizedWords(String sentence) {
        List<String> capitalizedWords = new ArrayList<>();
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }   
        return capitalizedWords;
    }
    public static void main(String[] args) {
        String sentence = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> capitalizedWords = extractCapitalizedWords(sentence);
        for (String word : capitalizedWords) {
            System.out.print(word + ", ");
        }
    }
}
