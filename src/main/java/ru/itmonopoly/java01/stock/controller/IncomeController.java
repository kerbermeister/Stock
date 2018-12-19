package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmonopoly.java01.stock.model.Income;
import ru.itmonopoly.java01.stock.model.IncomeItem;
import ru.itmonopoly.java01.stock.model.Part;
import ru.itmonopoly.java01.stock.repo.IncomeItemRepository;
import ru.itmonopoly.java01.stock.repo.IncomeRepository;
import ru.itmonopoly.java01.stock.repo.PartRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/types/add_income")
public class IncomeController {

    @Autowired
    IncomeRepository incomeRepository;
    PartRepository partRepository;
    IncomeItemRepository incomeItemRepository;

    public IncomeController(IncomeRepository incomeRepository, PartRepository partRepository, IncomeItemRepository incomeItemRepository) {
        this.incomeRepository = incomeRepository;
        this.partRepository = partRepository;
        this.incomeItemRepository = incomeItemRepository;
    }

    @PostMapping
    public String addIncome() {
        Iterable<Part> parts = partRepository.findAll();
        List<IncomeItem> incomeItems = new ArrayList<>();
        Income income = new Income(LocalDate.now());

        for (Part part : parts) {
            IncomeItem incomeItem = new IncomeItem(part, 10L, income);
            incomeItemRepository.save(incomeItem);
            incomeItems.add(incomeItem);
        }
        income.setItems(incomeItems);
        incomeRepository.save(income);
        return "redirect:/types";
    }
}
