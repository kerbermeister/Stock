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

    @Column(name = "type_name")
    private String typeName;
}
