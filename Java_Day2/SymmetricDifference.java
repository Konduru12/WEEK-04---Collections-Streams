import java.util.HashSet;
import java.util.Set;
public class SymmetricDifference{
    public static void main(String[] args){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(8);
        set1.add(6);
        set1.add(4);
        set1.add(2);

        set2.add(3);
        set2.add(7);
        set2.add(6);
        set2.add(1);
        set2.add(9);
        

        Set<Integer> result = new HashSet<>(set1);
        Set<Integer> temp = new HashSet<>(set2);
        result.removeAll(set2);
        temp.removeAll(set1);
        result.addAll(temp);

        System.out.println("Symmetric difference:" + result);
    }
}