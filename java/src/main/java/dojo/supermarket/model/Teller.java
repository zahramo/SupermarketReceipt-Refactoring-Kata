package dojo.supermarket.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teller {

    private final SupermarketCatalog catalog;
    private Map<Product, Offer> offers = new HashMap<>();

    public Teller(SupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    public void addSpecialOffer(Offer offer, Product product) {
        this.offers.put(product, offer);
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        List<ProductQuantity> productQuantities = theCart.getItems();
        for (ProductQuantity productQuantity: productQuantities) {
            Product product = productQuantity.getProduct();
            double quantity = productQuantity.getQuantity();
            double unitPrice = this.catalog.getUnitPrice(product);
            double price = quantity * unitPrice;
            receipt.addProduct(product, quantity, unitPrice, price);
        }
        handleOffers(receipt);

        return receipt;
    }

    private void handleOffers(Receipt receipt) {
        for (ReceiptItem receiptItem: receipt.getItems()) {
            Product product = receiptItem.getProduct();
            if (offers.containsKey(product)) {
                Offer offer = offers.get(product);
                double discountAmount = offer.handle((int)receiptItem.getQuantity(), receiptItem.getPrice());
                if (discountAmount > 0) receipt.addDiscount(new Discount(product, offer.getDescription(), -discountAmount));
            }
        }
    }

}
