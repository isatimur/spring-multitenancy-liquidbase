package com.timurisachenko.springliquidbasemultitenancydemo.model;

@lombok.Data
@javax.persistence.Entity
@javax.persistence.Table(name = "PRODUCT_TB")
public class Product implements java.io.Serializable {

    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    @javax.persistence.Column(name = "ID")
    private Long id;

    @javax.persistence.Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @javax.persistence.Column(name = "VALUE", nullable = false)
    private java.math.BigDecimal value;
}
