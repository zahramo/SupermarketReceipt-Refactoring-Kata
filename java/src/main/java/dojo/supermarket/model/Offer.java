package dojo.supermarket.model;

public interface Offer {
    public double handle(int quantity, double productPrice);
    public String getDescription();
}
