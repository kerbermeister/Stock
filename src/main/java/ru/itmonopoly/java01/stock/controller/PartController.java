package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmonopoly.java01.stock.model.Part;
import ru.itmonopoly.java01.stock.repo.ModelRepository;
import ru.itmonopoly.java01.stock.repo.PartRepository;


@Controller
@RequestMapping("/types/info/{id}/parts")
public class PartController {
    @Autowired
    PartRepository partRepository;
    ModelRepository modelRepository;

    public PartController(PartRepository partRepository, ModelRepository modelRepository) {
        this.partRepository = partRepository;
        this.modelRepository = modelRepository;
    }

    @RequestMapping
    public String partsList(@PathVariable ("id") Long id, Model model, Model model2) {
        model.addAttribute("id", id);
        model2.addAttribute("parts", partRepository.partsModel(id));
        return "part/parts_list";
    }

    @RequestMapping("/add_new")
    public String requestAddNewPage(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "part/add_new";
    }

    @PostMapping("/add_new")
    public String addNewPart(@PathVariable ("id") Long id, @RequestParam ("name") String name, @RequestParam ("spec") String spec) {
        Part part = new Part(name, spec);
        ru.itmonopoly.java01.stock.model.Model model = modelRepository.findById(id).get();
        part.addModel(model);
        partRepository.save(part);
        return "redirect:/types";
    }
}
