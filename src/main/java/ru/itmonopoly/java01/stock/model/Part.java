package ru.itmonopoly.java01.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Part {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String spec;

    public Part () {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpec() {
        return spec;
    }

    @ManyToMany
    private List<Model> models;

    public List<Model> getModels() {
        return models;
    }

    public boolean addModel(Model model) {
        models.add(model);
        return true;
    }

    public Part(String name, String spec) {
        this.spec = spec;
        this.name = name;
        models = new ArrayList<>();
    }
}
