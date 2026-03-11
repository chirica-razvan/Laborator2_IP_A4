package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    String name;
    String productType;
    String connectivityType;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(productType, product.productType) && Objects.equals(connectivityType, product.connectivityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productType, connectivityType);
    }
}
