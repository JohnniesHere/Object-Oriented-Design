public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add items
        cart.addItem(new Item("MASK001", 9.99, 2));
        cart.addItem(new Item("MASK002", 14.99, 1));
        cart.addItem(new Item("SANITIZER", 4.99, 3));

        // Print order using iterator
        cart.printOrder();

        // Pay using credit card
        PaymentStrategy creditCard = PaymentFactory.createPayment(
            "CREDIT", "John Doe", "1234567890123456", "123",
            "12/25", "ID12345"
        );
        cart.pay(creditCard);

        System.out.println("\nCreating new order...\n");

        // Create another order with gift card
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(new Item("MASK003", 19.99, 1));
        cart2.printOrder();

        PaymentStrategy giftCard = PaymentFactory.createPayment(
            "GIFT", "Jane Doe", "9876543210987654", "",
            "06/25", ""
        );
        cart2.pay(giftCard);
    }
}