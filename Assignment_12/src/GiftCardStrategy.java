public class GiftCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String expiryDate;

    public GiftCardStrategy(String name, String cardNumber, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Gift Card");
        System.out.println("Card holder: " + name);
        System.out.println("Card number: " + cardNumber.substring(cardNumber.length() - 4));
    }
}
