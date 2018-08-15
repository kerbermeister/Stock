package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class ProductsController {

    @Autowired
    private ProductsRepository repository;

    @GetMapping("/products")
    public String list(Model model) {

        model.addAttribute("products", repository.getProducts());

        return "products";
    }

    @GetMapping("/products/new")
    public String newProduct() {

        return "new";
    }

    @PostMapping(path = "/products",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String create(@RequestParam("name") String name, @RequestParam("cost") String cost) {
        repository.addProduct(new Product(name, Double.parseDouble(cost)));
        return "redirect:/products";
    }

    @PostMapping("/products/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteProduct(id);
        return "redirect:/products";
    }
}
