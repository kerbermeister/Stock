package ru.itmonopoly.java01.stock.model;

import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;

    @ManyToOne
    private Type type;
}
