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

    @PostMapping(path = "/products",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String create(ServletServerHttpRequest request) throws IOException {
        InputStream strem = request.getBody();
//        repository.addProduct(product);
        return "redirect:products";
    }
}
