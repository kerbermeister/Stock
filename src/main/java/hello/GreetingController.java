package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        List<Product> products = asList(
                new Product("Product 1", 88.7),
                new Product("Product 2", 828.7),
                new Product("Product 3", 188.7)
        );

        model.addAttribute("name", name);
        model.addAttribute("products", products);

        return "greeting";
    }

}
