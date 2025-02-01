import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart implements Iterable<Item> {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added: " + item.getProductCode() + " x" + item.getQuantity());
    }

    public void removeItem(Item item) {
        items.remove(item);
        System.out.println("Removed: " + item.getProductCode());
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void pay(PaymentStrategy paymentMethod) {
        double amount = calculateTotal();
        paymentMethod.pay(amount);
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    public void printOrder() {
        System.out.println("\nOrder Details:");
        System.out.println("---------------");
        for (Item item : items) {
            System.out.printf("Product: %s, Quantity: %d, Price: $%.2f%n", 
                            item.getProductCode(), item.getQuantity(), item.getPrice());
        }
        System.out.printf("Total Amount: $%.2f%n", calculateTotal());
        System.out.println("---------------\n");
    }
}