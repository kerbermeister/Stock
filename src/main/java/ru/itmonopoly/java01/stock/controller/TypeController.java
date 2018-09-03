package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmonopoly.java01.stock.repo.TypeRepository;

@Controller
@RequestMapping("/types")
public class TypeController {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping
    public String types(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        return "type/index";
    }

    @GetMapping("new")
    public String newType() {
        return "type/new";
    }

    @PostMapping
    public String create() {
        return "redirect:/types";
    }


}
