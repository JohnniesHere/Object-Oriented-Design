public class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private String ownerId;

    public CreditCardStrategy(String name, String cardNumber, String cvv,
                            String expiryDate, String ownerId) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.ownerId = ownerId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card");
        System.out.println("Card holder: " + name);
        System.out.println("Card number: " + cardNumber.substring(cardNumber.length() - 4));
    }
}