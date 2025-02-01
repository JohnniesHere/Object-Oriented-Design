import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SupermarketBillTest {
    private ProductCatalog catalog;
    private SupermarketBill bill;

    @Before
    public void setUp() {
        System.out.println("\n=== Setting up new test ===");
        catalog = new ProductCatalog();
        catalog.addProduct("apple", 1.0);
        catalog.addProduct("banana", 0.5);
        catalog.addProduct("orange", 0.75);
        System.out.println("Catalog initialized with:");
        System.out.println("- Apple: $1.0");
        System.out.println("- Banana: $0.5");
        System.out.println("- Orange: $0.75");
        bill = new SupermarketBill(catalog);
        System.out.println("New bill created");
    }

    @Test
    public void testBillWithThreeProducts() {
        System.out.println("\n=== Testing bill with three products ===");
        // First clear any existing products
        bill = new SupermarketBill(catalog);
        System.out.println("Created fresh bill");

        // Add products in specific order
        System.out.println("Adding products:");
        bill.addProduct("apple", 2);
        System.out.println("- Added 2 apples at $1.0 each = $2.0");
        bill.addProduct("banana", 3);
        System.out.println("- Added 3 bananas at $0.5 each = $1.5");
        bill.addProduct("orange", 1);
        System.out.println("- Added 1 orange at $0.75 = $0.75");

        double total = bill.calculateTotal();
        System.out.println("Expected total: $4.25 (2.0 + 1.5 + 0.75)");
        System.out.println("Actual total: $" + total);
        assertEquals(4.25, total, 0.001);
    }

    @Test
    public void testEmptyBill() {
        System.out.println("\n=== Testing empty bill ===");
        double total = bill.calculateTotal();
        System.out.println("Empty bill total: $" + total);
        assertEquals(0.0, total, 0.001);
    }

    @Test
    public void testAddAndRemoveProduct() {
        System.out.println("\n=== Testing add and remove product ===");
        System.out.println("Adding 1 apple");
        bill.addProduct("apple", 1);
        System.out.println("Total after adding: $" + bill.calculateTotal());
        System.out.println("Number of products: " + bill.getNumberOfProducts());

        System.out.println("Removing apple");
        bill.removeProduct("apple");
        double total = bill.calculateTotal();
        int numProducts = bill.getNumberOfProducts();
        System.out.println("Total after removing: $" + total);
        System.out.println("Number of products: " + numProducts);

        assertEquals(0.0, total, 0.001);
        assertEquals(0, numProducts);
    }

    @Test
    public void testAddTwoProducts() {
        System.out.println("\n=== Testing adding two products ===");
        System.out.println("Adding 1 apple");
        bill.addProduct("apple", 1);
        System.out.println("Adding 1 banana");
        bill.addProduct("banana", 1);
        int numProducts = bill.getNumberOfProducts();
        System.out.println("Number of products in bill: " + numProducts);
        assertEquals(2, numProducts);
    }

    @Test
    public void testFiftyPercentDiscount() {
        System.out.println("\n=== Testing 50% discount ===");
        System.out.println("Adding products:");
        bill.addProduct("apple", 2);
        System.out.println("- Added 2 apples at $1.0 each = $2.0");
        bill.addProduct("banana", 2);
        System.out.println("- Added 2 bananas at $0.5 each = $1.0");

        double fullAmount = bill.calculateTotal();
        System.out.println("Full amount before discount: $" + fullAmount);

        bill.setDiscount(0.5);
        double discountedAmount = bill.calculateTotal();
        System.out.println("Amount after 50% discount: $" + discountedAmount);
        System.out.println("Expected amount: $" + (fullAmount / 2));

        assertEquals(fullAmount / 2, discountedAmount, 0.001);
    }

    @Test
    public void testChangeQuantityTwice() {
        System.out.println("\n=== Testing changing quantity twice ===");
        System.out.println("Adding 1 apple");
        bill.addProduct("apple", 1);
        System.out.println("Initial quantity: " + bill.getQuantity("apple"));

        System.out.println("Changing quantity to 2");
        bill.changeQuantity("apple", 2);
        System.out.println("Quantity after first change: " + bill.getQuantity("apple"));

        System.out.println("Changing quantity to 3");
        bill.changeQuantity("apple", 3);
        int finalQuantity = bill.getQuantity("apple");
        System.out.println("Final quantity: " + finalQuantity);

        assertEquals(3, finalQuantity);
    }

    @Test
    public void testNonExistentItem() {
        System.out.println("\n=== Testing non-existent item ===");
        int quantity = bill.getQuantity("nonexistent");
        System.out.println("Quantity for non-existent item: " + quantity);
        assertEquals(0, quantity);
    }
}