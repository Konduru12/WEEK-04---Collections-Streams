import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ReverseAList{
    public static List<Integer> reverseArrayList(List<Integer> list){
        List<Integer> reverselist = new ArrayList<>();
        for(int i = list.size() - 1 ; i >= 0; i--){
            reverselist.add(list.get(i));
        }
        return reverselist;
    }
    public static List<Integer> reverseLinkedList(List<Integer> list){
        List<Integer> reverselist = new LinkedList<>();
        for(int i = list.size() - 1 ; i >= 0; i--){
            reverselist.add(list.get(i));
        }
        return reverselist;
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for(int j = 1; j<=5; j++){
            arrayList.add(j);
            linkedList.add(j);
        }
        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Reversed ArrayList: " + reverseArrayList(arrayList));
        System.out.println("Original LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reverseLinkedList(arrayList));
    }
}