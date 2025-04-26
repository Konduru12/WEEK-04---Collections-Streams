import java.util.*;

public class RepeatingWords{
    public static Set<String> find(String text) {
        Set<String> seen = new HashSet<>();
        Set<String> repeats = new LinkedHashSet<>();
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
        for (String word : words) {
            if (!seen.add(word)) {
                repeats.add(word);
            }
        }   
        return repeats;
    }
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> repeatingWords = find(text);
        for (String word : repeatingWords) {
            System.out.print(word + ", ");
        }
    }
}
