package dojo.supermarket.model;

public class ThreeForTowOffer implements Offer {
    private final Product product;
    private double argument;
    private static final int payableQuantity = 2;
    private static final int actualQuantity = 3;
    private static final int quantityRate = payableQuantity/actualQuantity;
    private static final String description = "3 for 2";

    public ThreeForTowOffer(Product product, double argument) {
        this.argument = argument;
        this.product = product;
    }

    @Override
    public double handle(int quantity, double productPrice) {
        if (quantity > payableQuantity) {
            double payablePrice = (quantity * quantityRate * productPrice) + (quantity % actualQuantity * productPrice);
            double actualPrice = quantity * productPrice;
            return actualPrice - payablePrice;
        } else return 0;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
