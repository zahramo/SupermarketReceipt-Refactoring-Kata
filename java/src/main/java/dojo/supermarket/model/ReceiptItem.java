package dojo.supermarket.model;

import java.util.Objects;

public class ReceiptItem {
    private final Product product;
    private final double price;
    private double totalPrice;
    private final double quantity;

    public ReceiptItem(Product p, double quantity, double price, double totalPrice) {
        this.product = p;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object otherItem) {
        if (this == otherItem) return true;
        if (otherItem == null || getClass() != otherItem.getClass()) return false;
        ReceiptItem otherReceiptItem = (ReceiptItem) otherItem;
        return Double.compare(otherReceiptItem.price, price) == 0 &&
                Double.compare(otherReceiptItem.totalPrice, totalPrice) == 0 &&
                Double.compare(otherReceiptItem.quantity, quantity) == 0 &&
                Objects.equals(product, otherReceiptItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, price, totalPrice, quantity);
    }


}
