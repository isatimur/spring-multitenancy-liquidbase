package com.timurisachenko.springliquidbasemultitenancydemo.model;

@javax.persistence.Entity
@javax.persistence.Table(name = "persons")
public class Person {

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE)
    @javax.persistence.Column(name = "id")
    private Long id;

    @javax.persistence.Column
    private String name;

    @javax.persistence.Column
    private String height;

    public Person() {
    }

    public Person(String name, String height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
