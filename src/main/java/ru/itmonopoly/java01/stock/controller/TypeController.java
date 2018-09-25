package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmonopoly.java01.stock.model.IncomeItem;
import ru.itmonopoly.java01.stock.model.Part;
import ru.itmonopoly.java01.stock.model.Type;
import ru.itmonopoly.java01.stock.repo.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/types")
public class TypeController {

    private final TypeRepository typeRepository;
    private final ModelRepository modelRepository;
    private final PartRepository partRepository;
    private final IncomeItemRepository incomeItemRepository;
    private final OutcomeItemRepository outcomeItemRepository;

    @Autowired
    public TypeController(TypeRepository typeRepository, ModelRepository modelRepository, PartRepository partRepository, IncomeItemRepository incomeItemRepository
    , OutcomeItemRepository outcomeItemRepository) {
        this.typeRepository = typeRepository;
        this.modelRepository = modelRepository;
        this.partRepository = partRepository;
        this.incomeItemRepository = incomeItemRepository;
        this.outcomeItemRepository = outcomeItemRepository;
    }

    @PostMapping
    public String filter(@RequestParam ("filter") String filter, Model model) {
        if (!filter.isEmpty() && filter != null) {
            model.addAttribute("parts", partRepository.findPartBySpec(filter));
        } else
            model.addAttribute("parts", partRepository.findAll());

        model.addAttribute("types", typeRepository.findAll());
        return "type/index";
    }

    @GetMapping
    public String types(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("parts", partRepository.findAll());
        List<Object[]> list = incomeItemRepository.getPartsQty();
        for (Object[] obj : list) {
            BigInteger id = (BigInteger) obj[0];
            BigDecimal count = (BigDecimal) obj[1];
            System.out.println("id: " + id + " | count: " + count);
        }

        model.addAttribute("partsQty", list);
        Iterable<Part> parts = partRepository.findAll();
        Long partTotalIncomeQty = 0L;
        Long partTotalOutcomeQty = 0L;
        Long total = 0L;
        for (Part part : parts) {
            Long partId = part.getId();
            List<Long> partOutcomeQuantity = outcomeItemRepository.getPartOutcomeQty(partId);
            List<Long> partIncomeQuantity = incomeItemRepository.getPartIncomeQty(partId);

            for (Long qty : partIncomeQuantity) {
                partTotalIncomeQty+=qty;
            }
            for (Long qty : partOutcomeQuantity) {
                partTotalOutcomeQty+=qty;
            }

            total+=(partTotalIncomeQty-partTotalOutcomeQty);
        }
        
        model.addAttribute("totalItems", total);
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

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        typeRepository.deleteById(id);
        return "redirect:/types";
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable ("id") Long id) {
        model.addAttribute("id", id);
        return "type/edit";
    }

    @PostMapping("/edit/{id}")
    public String change (@PathVariable("id") Long id, @RequestParam ("typeName") String name) {
        Type type = typeRepository.findById(id).get();
        type.setTypeName(name);
        typeRepository.save(type);
        return "redirect:/types";
    }
}
