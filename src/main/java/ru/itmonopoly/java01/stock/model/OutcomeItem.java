package ru.itmonopoly.java01.stock.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OutcomeItem {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Part part;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Outcome outcome;

    @NotNull
    private Long count;

    public OutcomeItem() {

    }

    public OutcomeItem(@NotNull Part part, Outcome outcome, @NotNull Long count) {
        this.part = part;
        this.outcome = outcome;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
