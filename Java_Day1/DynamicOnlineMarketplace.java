interface Category{
    public String getCategory();
}
enum BookCategory implements Category {
    FICTION, NONFICTION;
    @Override
    public String getCategory() {
        return "Book";
    }
}
enum ClothingCategory implements Category{
    MEN,WOMEN,KIDS;
    @Override
    public String getCategory(){
        return "Clothes";
    }
}
enum GadjetsCategory implements Category{
    PHONE,LAPTOP,Tablet;
    @Override
    public String getCategory(){
        return "Gadjets";
    }
}
class Product<T extends Category>{
    final private String name;
    final private T category;
    private int price;
    public Product(String name,T category,int price){
        this.name=name;
        this.category=category;
        this.price=price;
    }
    public String getname(){
        return name;
    }
    public T getcategory(){
        return category;
    }
    public int getprice(){
        return price;
    }
    public void applyDiscount(int percent){
        price=price-(price*percent/100);
    }
    public static <T extends Category> void applyDis(Product<T> product,int percent){
        product.applyDiscount(percent);
    }
    public void display(){
        System.out.println(name+", "+category.getCategory()+" ,"+price);
    }
}
public class DynamicOnlineMarketplace{
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Product<BookCategory> bc=new Product<>("Harry Pother",BookCategory.FICTION,400);
        Product<ClothingCategory> cc=new Product<>("Skirts",ClothingCategory.MEN,500);
        Product<GadjetsCategory> gc=new Product<>("Mobile phones",GadjetsCategory.LAPTOP,50000);
        bc.applyDis(bc,5);
        cc.applyDis(cc,10);
        gc.applyDis(gc,15);
        System.out.println("After applying discount");
        bc.display();
        cc.display();
        gc.display();

    }
}
