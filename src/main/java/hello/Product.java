package hello;

import java.util.Objects;

public class Product {
    private static Long counter = 0L;

    private Long id = counter++;
    private String name;
    private Double cost;

    public Product(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Product(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
