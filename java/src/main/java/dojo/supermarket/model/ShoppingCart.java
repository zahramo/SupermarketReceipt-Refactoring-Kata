package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final List<ProductQuantity> items = new ArrayList<>();
    private Map<Product, Double> productQuantities = new HashMap<>();


    List<ProductQuantity> getItems() {
        return new ArrayList<>(items);
    }

    void addItem(Product product) {
        this.addItemQuantity(product, 1.0);
    }

    Map<Product, Double> productQuantities() {
        return productQuantities;
    }


    public void addItemQuantity(Product product, double quantity) {
        items.add(new ProductQuantity(product, quantity));
        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.get(product) + quantity);
        } else {
            productQuantities.put(product, quantity);
        }
    }

    void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        for (Product product: productQuantities().keySet()) {
            double quantity = productQuantities.get(product);
            if (offers.containsKey(product)) {
                Offer offer = offers.get(product);
                double unitPrice = catalog.getUnitPrice(product);
                int quantityAsInt = (int) quantity;
                if (offer.getOfferType() == SpecialOfferType.TwoForAmount && quantityAsInt >= 2) {
                    double unitOfferedPrices = offer.getOfferUnitPrice() * (quantityAsInt/2);
                    double remainingPrice = (quantityAsInt % 2) * unitPrice;
                    double discountTotal = unitPrice * quantity - (unitOfferedPrices + remainingPrice);
                    receipt.addDiscount(new Discount(product, "2 for " + offer.getOfferUnitPrice(), -discountTotal));
                }
                if (offer.getOfferType() == SpecialOfferType.ThreeForTwo && quantityAsInt > 2) {
                    double discountAmount = quantity * unitPrice - (((quantityAsInt/3) * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
                    receipt.addDiscount(new Discount(product, "3 for 2", -discountAmount));
                }
                if (offer.getOfferType() == SpecialOfferType.TenPercentDiscount) {
                    receipt.addDiscount(new Discount(product, offer.getOfferUnitPrice() + "% off", -quantity * unitPrice * offer.getOfferUnitPrice() / 100.0));
                }
                if (offer.getOfferType() == SpecialOfferType.FiveForAmount && quantityAsInt >= 5) {
                    double discountTotal = unitPrice * quantity - (offer.getOfferUnitPrice() * (quantityAsInt/5) + quantityAsInt % 5 * unitPrice);
                    receipt.addDiscount(new Discount(product,  "5 for " + offer.getOfferUnitPrice(), -discountTotal));
                }
            }

        }
    }
}
