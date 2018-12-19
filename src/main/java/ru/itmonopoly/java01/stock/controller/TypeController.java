package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmonopoly.java01.stock.model.Part;
import ru.itmonopoly.java01.stock.model.Type;
import ru.itmonopoly.java01.stock.repo.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/types")
public class TypeController {

    private final TypeRepository typeRepository;
    private final PartRepository partRepository;

    @Autowired
    public TypeController(TypeRepository typeRepository,
                          PartRepository partRepository) {

        this.typeRepository = typeRepository;
        this.partRepository = partRepository;
    }

    @GetMapping
    public String types(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("parts", partRepository.findAll());
        model.addAttribute("size", typeRepository.count());
        return "type/index";
    }

    @GetMapping("/new")
    public String newType() {
        return "type/new";
    }

    @PostMapping("/new")
    public String create(@RequestParam String typeName) {
        typeRepository.save(new Type(typeName));
        return "redirect:/types";
    }

    @DeleteMapping("/delete/type_id={id}")
    public String delete(@PathVariable("id") Long id) {
        typeRepository.deleteById(id);
        return "redirect:/types";
    }


    @GetMapping("/edit/type_id={id}")
    public String edit(Model model, @PathVariable ("id") Long id) {
        model.addAttribute("id", id);
        return "type/edit";
    }

    @PostMapping("/edit/type_id={id}")
    public String change (@PathVariable("id") Long id, @RequestParam ("typeName") String name) {
        Type type = typeRepository.findById(id).get();
        type.setTypeName(name);
        typeRepository.save(type);
        return "redirect:/types";
    }

    @PostMapping
    public String search(@RequestParam("filter") String filter, Model model) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("types", typeRepository.findTypeByName(filter));
            model.addAttribute("size", typeRepository.findTypeByName(filter).size());
        } else {
            model.addAttribute("types", typeRepository.findAll());
            model.addAttribute("size", typeRepository.count());
        }
        return "type/index";
    }
}
