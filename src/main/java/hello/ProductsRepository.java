package hello;

import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.Arrays.asList;

@Component
public class ProductsRepository {

    private Set<Product> products;

    public ProductsRepository() {
        products = new HashSet<>(asList(
                new Product("Product 1", 88.7),
                new Product("Product 2", 828.7),
                new Product("Product 3", 188.7)
        ));
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.remove(new Product(id));
    }
}
