package dojo.supermarket.model;

public class Offer {
    private SpecialOfferType offerType;
    private final Product product;
    private double offerUnitPrice;

    public Offer(SpecialOfferType offerType, Product product, double offerUnitPrice) {
        this.offerType = offerType;
        this.offerUnitPrice = offerUnitPrice;
        this.product = product;
    }

    public SpecialOfferType getOfferType() {
        return offerType;
    }

    public Product getProduct() {
        return product;
    }

    public double getOfferUnitPrice() {
        return offerUnitPrice;
    }
}
