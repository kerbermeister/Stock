package ru.itmonopoly.java01.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmonopoly.java01.stock.model.IncomeItem;
import ru.itmonopoly.java01.stock.model.Outcome;
import ru.itmonopoly.java01.stock.model.OutcomeItem;
import ru.itmonopoly.java01.stock.model.Part;
import ru.itmonopoly.java01.stock.repo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/types/add_outcome")
public class OutcomeController {

    @Autowired
    PartRepository partRepository;
    IncomeRepository incomeRepository;
    IncomeItemRepository incomeItemRepository;
    OutcomeRepository outcomeRepository;
    OutcomeItemRepository outcomeItemRepository;
    TypeRepository typeRepository;

    public OutcomeController (PartRepository partRepository, IncomeRepository incomeRepository, IncomeItemRepository incomeItemRepository,
                              OutcomeItemRepository outcomeItemRepository, OutcomeRepository outcomeRepository, TypeRepository typeRepository) {
        this.partRepository = partRepository;
        this.incomeRepository = incomeRepository;
        this.incomeItemRepository = incomeItemRepository;
        this.outcomeRepository = outcomeRepository;
        this.outcomeItemRepository = outcomeItemRepository;
        this.typeRepository = typeRepository;
    }

    @PostMapping
    public String makeOutcome(Model model) {
        Outcome outcome = new Outcome(LocalDate.now());
        Long qtyToOutcome = 5L;
        List<OutcomeItem> outcomeItemList = new ArrayList<>();

        Long partTotalIncomeQty = 0L;
        Long partTotalOutcomeQty = 0L;
        List<Part> parts = partRepository.getAllParts();
        for (Part part : parts) {
            Long partId = part.getId();
            List<Long> partIncomeQuantity = incomeItemRepository.getPartIncomeQty(partId);
            List<Long> partOutcomeQuantity = outcomeItemRepository.getPartOutcomeQty(partId);

            for (Long qty : partIncomeQuantity) {
                partTotalIncomeQty+=qty;
            }
            for (Long qty : partOutcomeQuantity) {
                partTotalOutcomeQty+=qty;
            }

            if ((partTotalIncomeQty-partTotalOutcomeQty)!=0 && (partTotalIncomeQty-partTotalOutcomeQty) >= qtyToOutcome) {
                OutcomeItem outcomeItem = new OutcomeItem(part, outcome, qtyToOutcome);
                outcomeItemRepository.save(outcomeItem);
                outcomeItemList.add(outcomeItem);
            }

        }

        outcome.setItems(outcomeItemList);
        outcomeRepository.save(outcome);

        return "redirect:/types";
    }
}
