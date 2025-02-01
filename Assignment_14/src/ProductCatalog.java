import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Double> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    public void addProduct(String name, double price) {
        products.put(name, price);
    }

    public double getPrice(String name) {
        return products.getOrDefault(name, 0.0);
    }

    public void updatePrice(String name, double newPrice) {
        if (products.containsKey(name)) {
            products.put(name, newPrice);
        }
    }
}
