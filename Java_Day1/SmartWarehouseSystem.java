import java.util.ArrayList;
import java.util.List;
abstract class SmartWarehouse{
    final private String name;
    public SmartWarehouse(String name){
        this.name=name;
    }
    public String getname(){
        return name;
    }
    public abstract String getcategory();
}
class Electronics extends SmartWarehouse{
    public Electronics(String name){
        super(name);
    }
    @Override
    public String getcategory(){
        return "Electronics";
    }
}
class Groceries extends SmartWarehouse{
    public Groceries(String name){
        super(name);
    }
    @Override
    public String getcategory(){
        return "Groceries";
    }
}
class Furniture extends SmartWarehouse{
    public Furniture(String name){
        super(name);
    }
    @Override
    public String getcategory(){
        return "Furniture";
    }
}
class Storage <T extends SmartWarehouse>{
    final private List<T> items=new ArrayList<>();
    public void additem(T item){
        items.add(item);
    }
    public List<T> getitem(){
        return items;
    }
    public static void displayitems(List<? extends SmartWarehouse> items){
        for(SmartWarehouse item:items){
            System.out.println(item.getcategory()+" : "+item.getname());
        }
    }
}
public class SmartWarehouseSystem{
    public static void main(String[] args) {
        Storage<Electronics> es = new Storage<>();
        es.additem(new Electronics("Tab"));
        es.additem(new Electronics("Laptop"));
        es.additem(new Electronics("Mobile Phone"));
        Storage<Groceries> gl = new Storage<>();
        gl.additem(new Groceries("Chocolates"));
        gl.additem(new Groceries("Biscuits"));
        gl.additem(new Groceries("Ice Cream"));
        Storage<Furniture> fs = new Storage<>();
        fs.additem(new Furniture("Sofa"));
        fs.additem(new Furniture("Dining table"));
        fs.additem(new Furniture("Chairs"));
        System.out.println();
        System.out.println("Displaying ware house items: ");
        System.out.println();
        Storage.displayitems(es.getitem());
        System.out.println();
        Storage.displayitems(gl.getitem());
        System.out.println();
        Storage.displayitems(fs.getitem());
    }
}