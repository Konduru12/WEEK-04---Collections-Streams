import java.util.*;
public class RotateElements{
    public static List<Integer> listrotation(List<Integer> list, int position){
        int size = list.size();
        List<Integer> rotatedlist = new ArrayList<>();
        position = position % size;
        for(int i = position; i < size; i++){
            rotatedlist.add(list.get(i));
        }
        for(int i = 0; i<position; i++){
            rotatedlist.add(list.get(i));
        }
        return rotatedlist;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40,50);
        int rotate = 2;
        List<Integer> result = listrotation(list, rotate);
        System.out.println("Rotated List:" + result);
    }
}