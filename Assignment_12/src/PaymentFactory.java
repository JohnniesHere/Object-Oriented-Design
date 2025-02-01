public class PaymentFactory {
    public static PaymentStrategy createPayment(String type, String name, String cardNumber,
                                              String cvv, String expiryDate, String ownerId) {
        if (type.equalsIgnoreCase("CREDIT")) {
            return new CreditCardStrategy(name, cardNumber, cvv, expiryDate, ownerId);
        } else if (type.equalsIgnoreCase("GIFT")) {
            return new GiftCardStrategy(name, cardNumber, expiryDate);
        }
        return null;
    }
}