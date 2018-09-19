package ru.itmonopoly.java01.stock.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class IncomeItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Income income;

    @NotNull
    @ManyToOne
    private Part part;

    public IncomeItem(@NotNull Part part, @NotNull Long count, Income income) {
        this.part = part;
        this.count = count;
        this.income = income;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @NotNull
    private Long count;
}
