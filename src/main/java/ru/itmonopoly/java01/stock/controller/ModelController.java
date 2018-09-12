package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmonopoly.java01.stock.model.Type;
import ru.itmonopoly.java01.stock.repo.ModelRepository;
import ru.itmonopoly.java01.stock.repo.TypeRepository;

@Controller
@RequestMapping("/types/info")
public class ModelController {

    @Autowired
    private final TypeRepository typeRepository;
    private final ModelRepository modelRepository;

    @Autowired
    public ModelController(TypeRepository typeRepository, ModelRepository modelRepository) {
        this.typeRepository = typeRepository;
        this.modelRepository = modelRepository;
    }

    @GetMapping("/{id}")
    public String typeInfo(@PathVariable("id") Long id, Model model, Model model2) {
        model.addAttribute("models", modelRepository.findAll());
        model2.addAttribute("id", id);
        return "type/info";
    }

    @GetMapping("/{id}/add")
    public String addModel(Model model, @PathVariable ("id") Long id) {
        model.addAttribute("id", id);
        return "type/add_model";
    }

    @PostMapping("/{id}/add")
    public String createModel(Model modelSpring, @PathVariable ("id") Long id, @RequestParam ("name") String name, @RequestParam ("vendor_code") String vendor_code) {
        Type type = typeRepository.findById(id).get();
        ru.itmonopoly.java01.stock.model.Model model = new ru.itmonopoly.java01.stock.model.Model(name, vendor_code, type);
        modelRepository.save(model);
        modelSpring.addAttribute("models", modelRepository.findAll());
        return "redirect:/types/info/{id}";
    }
}
