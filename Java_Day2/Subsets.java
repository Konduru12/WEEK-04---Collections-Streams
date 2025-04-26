import java.util.*;
public class Subsets{
    public static void main(String[] args) {
     Set<Integer> set1 = new HashSet<>(Set.of(1,2));
     Set<Integer> set2 = new HashSet<>(Set.of(1,2,3));
     boolean isSubset = set2.containsAll(set1);
     System.out.println("Set 1 is a subset of set2 : " + isSubset);   
    }
}