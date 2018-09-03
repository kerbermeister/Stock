package ru.itmonopoly.java01.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Model {

    @Id
    private Long id;

    @Column
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;

    @ManyToOne
    private Type type;
}
