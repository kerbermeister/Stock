package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmonopoly.java01.stock.repo.PartRepository;

@Controller
@RequestMapping("/types/info/{id}/parts")
public class PartController {
    @Autowired
    PartRepository partRepository;

    @RequestMapping
    public String partsList(@PathVariable ("id") Long id, Model model, Model model2) {
        model.addAttribute("id", id);
        model2.addAttribute("parts", partRepository.findAll());
        return "part/parts_list";
    }
}
