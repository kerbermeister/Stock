package ru.itmonopoly.java01.stock.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Income {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @OneToMany(mappedBy = "income")
    private List<IncomeItem> items;

    public Income(LocalDate date) {
        this.date = date;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<IncomeItem> getItems() {
        return items;
    }

    public void setItems(List<IncomeItem> items) {
        this.items = items;
    }
}
