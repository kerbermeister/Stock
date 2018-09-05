package ru.itmonopoly.java01.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getId() {

        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    @Column(name = "type_name")
    private String typeName;

    public Type () {}

    public Type(String name) {
        typeName = name;
    }
}
