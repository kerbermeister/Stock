package ru.itmonopoly.java01.stock.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Model {
    public Model () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    public Model(String name, String vendorCode, Type type) {
        this.name = name;
        this.vendorCode = vendorCode;
        this.type = type;
    }

    @Column(name = "vendor_code")
    private String vendorCode;

    @ManyToOne
    private Type type;

    @ManyToMany(mappedBy = "models")
    private List<Part> parts;

}
