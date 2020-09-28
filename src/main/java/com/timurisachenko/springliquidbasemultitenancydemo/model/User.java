package com.timurisachenko.springliquidbasemultitenancydemo.model;

@lombok.Data
@javax.persistence.Entity
@javax.persistence.Table(name = "USER_TB")
public class User implements java.io.Serializable {

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Column(name = "ID")
    private Long id;

    @javax.persistence.Column(name = "NAME", length = 100, nullable = false)
    private String name;
}
