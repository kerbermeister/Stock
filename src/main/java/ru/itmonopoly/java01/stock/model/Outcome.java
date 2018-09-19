package ru.itmonopoly.java01.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Outcome {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate localDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<OutcomeItem> getItems() {
        return items;
    }

    public void setItems(List<OutcomeItem> items) {
        this.items = items;
    }

    @OneToMany(mappedBy = "outcome")
    private List<OutcomeItem> items;

    public Outcome(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Outcome() {}


}
