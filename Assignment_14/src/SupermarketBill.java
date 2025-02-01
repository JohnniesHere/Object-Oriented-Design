import java.util.HashMap;
import java.util.Map;

public class SupermarketBill {
    private Map<String, Integer> quantities;
    private ProductCatalog catalog;
    private double discount;

    public SupermarketBill(ProductCatalog catalog) {
        this.quantities = new HashMap<>();
        this.catalog = catalog;
        this.discount = 0.0;
    }

    public void addProduct(String name, int quantity) {
        if (quantity > 0) {
            quantities.put(name, quantity);
        }
    }

    public void changeQuantity(String name, int newQuantity) {
        if (quantities.containsKey(name)) {
            if (newQuantity > 0) {
                quantities.put(name, newQuantity);
            } else {
                quantities.remove(name);
            }
        }
    }

    public void changePrice(String name, double newPrice) {
        catalog.updatePrice(name, newPrice);
    }

    public void removeProduct(String name) {
        quantities.remove(name);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : quantities.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            double price = catalog.getPrice(productName);
            double itemTotal = price * quantity;
            System.out.println("Product: " + productName + ", Quantity: " + quantity + ", Price: " + price + ", Item Total: " + itemTotal);
            total += itemTotal;
        }
        System.out.println("Final Total: " + total);
        return total * (1 - discount);
    }

    public int getNumberOfProducts() {
        return quantities.size();
    }

    public int getQuantity(String name) {
        return quantities.getOrDefault(name, 0);
    }

    public void setDiscount(double discount) {
        if (discount >= 0.0 && discount <= 1.0) {
            this.discount = discount;
        }
    }
}