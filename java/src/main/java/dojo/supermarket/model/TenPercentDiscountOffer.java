package dojo.supermarket.model;

public class TenPercentDiscountOffer implements Offer {
    private final Product product;
    private double argument;
    private static final int payableQuantity = 2;
    private static final int actualQuantity = 3;
    private static final int quantityRate = payableQuantity / actualQuantity;
    private static final String description = "% off";

    public TenPercentDiscountOffer(Product product, double argument) {
        this.argument = argument;
        this.product = product;
    }

    @Override
    public double handle(int quantity, double productPrice) {
        return quantity * productPrice * argument / 100.0;
    }

    @Override
    public String getDescription() {
        return argument + description;
    }
}
