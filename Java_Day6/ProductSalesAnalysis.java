import java.util.*;
import java.util.stream.Collectors;
class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
class ProductSales {
    String productId;
    double totalRevenue;
    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }
    @Override
    public String toString() {
        return productId + " : Rs." + totalRevenue;
    }
}
public class ProductSalesAnalysis {
    static List<ProductSales> processSales(List<Sale> salesList) {
        return salesList.stream()
                .filter(sale -> sale.quantity > 10)  
                .map(sale -> new ProductSales(sale.productId, sale.quantity * sale.price))
                .sorted((ps1, ps2) -> Double.compare(ps2.totalRevenue, ps1.totalRevenue))  
                .limit(5) 
                .collect(Collectors.toList());  
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 5, 100),
                new Sale("P2", 10, 50),
                new Sale("P3", 15, 200),
                new Sale("P4", 20, 40),
                new Sale("P5", 25, 70),
                new Sale("P6", 30, 300),
                new Sale("P7", 35, 150)
        );
        List<ProductSales> topProducts = processSales(sales);
        topProducts.forEach(System.out::println);
    }
}
