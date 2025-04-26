import java.util.*;
public class FrequencyOfElements{
    public static Map<String, Integer> countingwords(List<String> list){
        Map<String, Integer> frequencywords = new HashMap<>();
        for(String item: list){
            frequencywords.put(item, frequencywords.getOrDefault(item, 0) + 1);
        }
        return frequencywords;
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana","apple","banana","orange","guaua");
        Map<String, Integer> result = countingwords(words);
        System.out.println("Frequency of Words:" + result);
    }
}