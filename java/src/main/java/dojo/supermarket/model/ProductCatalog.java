package dojo.supermarket.model;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog implements SupermarketCatalog {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();

    @Override
    public void addProduct(Product product, double price) {
        this.products.put(product.getName(), product);
        this.prices.put(product.getName(), price);
    }

    @Override
    public double getUnitPrice(Product product) {
        return this.prices.get(product.getName());
    }
}
