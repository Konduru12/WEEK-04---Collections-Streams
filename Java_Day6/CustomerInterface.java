import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class CustomerInterface{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("apple", "banana", "mango", "grape");
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        names.forEach(printUpperCase);
    }
}
