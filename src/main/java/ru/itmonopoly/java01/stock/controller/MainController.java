package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itmonopoly.java01.stock.repo.*;

@Controller
public class MainController {
    private final TypeRepository typeRepository;
    private final ModelRepository modelRepository;
    private final PartRepository partRepository;
    private final IncomeItemRepository incomeItemRepository;
    private final OutcomeItemRepository outcomeItemRepository;

    @Autowired
    public MainController(TypeRepository typeRepository, ModelRepository modelRepository, PartRepository partRepository, IncomeItemRepository incomeItemRepository
            , OutcomeItemRepository outcomeItemRepository) {
        this.typeRepository = typeRepository;
        this.modelRepository = modelRepository;
        this.partRepository = partRepository;
        this.incomeItemRepository = incomeItemRepository;
        this.outcomeItemRepository = outcomeItemRepository;
    }

    @PostMapping("/all_parts")
    public String filter(@RequestParam("filter") String filter, Model model) {
        if (!filter.isEmpty() && filter != null) {
            model.addAttribute("parts", partRepository.findPartBySpec(filter));
            model.addAttribute("size", partRepository.findPartBySpec(filter).size());
        } else {
            model.addAttribute("parts", partRepository.findAll());
            model.addAttribute("size", partRepository.count());
        }
        return "part/all_parts";
    }

    @GetMapping("/all_parts")
    public String allParts(Model model) {
        model.addAttribute("parts", partRepository.findAll());
        model.addAttribute("size", partRepository.count());
        return "part/all_parts";
    }

    @GetMapping("/all_models")
    public String allModels(Model model) {
        model.addAttribute("models", modelRepository.findAll());
        model.addAttribute("size", modelRepository.count());
        return "model/all_models";
    }

    @PostMapping("/all_models")
    public String searchModels(@RequestParam("model_filter") String filter, Model model) {
        if(!filter.isEmpty() && filter!=null) {
            model.addAttribute("models", modelRepository.findModelByName(filter));
            model.addAttribute("size", modelRepository.findModelByName(filter).size());
        } else {
            model.addAttribute("models", modelRepository.findAll());
            model.addAttribute("size", modelRepository.count());
        }
        return "model/all_models";
    }
}
