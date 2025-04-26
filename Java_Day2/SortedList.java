import java.util.*;
public class SortedList{
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(2,4,3,5,9,10));
        List<Integer> sortList = new ArrayList<>(set);
        Collections.sort(sortList);
        System.out.println("Sorted List:" + sortList);

    }
}