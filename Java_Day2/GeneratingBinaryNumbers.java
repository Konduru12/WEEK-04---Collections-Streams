import java.util.*;
public class GeneratingBinaryNumbers {
    public static List<String> binary(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }
    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = binary(N);
        System.out.println(binaryNumbers); 
    }
}
