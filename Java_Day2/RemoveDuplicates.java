import java.util.*;
public class RemoveDuplicates{
    public static List<Integer> removeduplicatefromlist(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for(Integer num : list){
            if(!seen.contains(num)){
                seen.add(num);
                result.add(num);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,1,1,1,1,1,1,1,1,4,5,6,3);
        List<Integer> output = removeduplicatefromlist(list);
        System.out.println("List after removing Duplicates:" + output);
    }
}