package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> items = new ArrayList<>();
    private List<Discount> discounts = new ArrayList<>();

    public Double getTotalPrice() {
        double totalPrice = 0.0;
        for (ReceiptItem item : this.items) {
            totalPrice += item.getTotalPrice();
        }
        for (Discount discount : this.discounts) {
            totalPrice += discount.getDiscountAmount();
        }
        return totalPrice;
    }

    public void addProduct(ReceiptItem receiptItem) {
        this.items.add(receiptItem);
    }

    public List<ReceiptItem> getItems() {
        return new ArrayList<>(this.items);
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
