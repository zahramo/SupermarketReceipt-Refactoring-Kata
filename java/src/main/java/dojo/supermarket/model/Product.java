package dojo.supermarket.model;

import java.util.Objects;

public class Product {
    private final String name;
    private final ProductUnit unit;

    public Product(String name, ProductUnit unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }


    public ProductUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object otherProduct) {
        if (this == otherProduct) return true;
        if (otherProduct == null || getClass() != otherProduct.getClass()) return false;
        return Objects.equals(name, ((Product) otherProduct).name) &&
                unit == ((Product) otherProduct).unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit);
    }
}
