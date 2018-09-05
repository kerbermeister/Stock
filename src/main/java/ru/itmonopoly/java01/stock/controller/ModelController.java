package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmonopoly.java01.stock.model.Type;
import ru.itmonopoly.java01.stock.repo.ModelRepository;
import ru.itmonopoly.java01.stock.repo.TypeRepository;

@Controller
@RequestMapping("/types/info/{id}")
public class ModelController {

    @Autowired
    private final TypeRepository typeRepository;
    private final ModelRepository modelRepository;

    @Autowired
    public ModelController(TypeRepository typeRepository, ModelRepository modelRepository) {
        this.typeRepository = typeRepository;
        this.modelRepository = modelRepository;
    }

    @GetMapping
    public String typeInfo(@PathVariable("id") Long id, Model model, Model model2) {
        model.addAttribute("models", modelRepository.findAll());
        model2.addAttribute("typeId", id);
        return "type/info";
    }

    @GetMapping("/add")
    public String addModel() {
        return "type/add_model";
    }
}
