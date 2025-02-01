public class Item {
    private String productCode;
    private double price;
    private int quantity;

    public Item(String productCode, double price, int quantity) {
        this.productCode = productCode;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price * quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }
}