package dojo.supermarket.model;

public class TwoForAmountOffer implements Offer {
    private final Product product;
    private double argument;
    private static final int payableQuantity = 2;
    private static final String description = "2 for ";

    public TwoForAmountOffer(Product product, double argument) {
        this.argument = argument;
        this.product = product;
    }

    @Override
    public double handle(int quantity, double productPrice) {
        if (quantity > payableQuantity) {
            double payablePrice = argument * quantity / payableQuantity + (quantity % payableQuantity) * productPrice;
            double actualPrice = quantity * productPrice;
            return actualPrice - payablePrice;
        } else return 0;
    }

    @Override
    public String getDescription() {
        return description + this.argument;
    }
}
