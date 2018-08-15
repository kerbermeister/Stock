package hello;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class ProductsRepository {

    private List<Product> products;

    public ProductsRepository() {
        products = new ArrayList<>(asList(
                new Product("Product 1", 88.7),
                new Product("Product 2", 828.7),
                new Product("Product 3", 188.7)
        ));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
