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

    public void addSpecialOffer(Offer newSpecialOffer) {
        this.offers.put(newSpecialOffer.getProduct(), newSpecialOffer);
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        List<ProductQuantity> productQuantities = theCart.getItems();
        for (ProductQuantity productQuantity: productQuantities) {
            Product product = productQuantity.getProduct();
            double quantity = productQuantity.getQuantity();
            double unitPrice = this.catalog.getUnitPrice(product);
            double price = quantity * unitPrice;
            receipt.addProduct(new ReceiptItem(product, quantity, unitPrice, price));
        }
        theCart.handleOffers(receipt, this.offers, this.catalog);

        return receipt;
    }

}
