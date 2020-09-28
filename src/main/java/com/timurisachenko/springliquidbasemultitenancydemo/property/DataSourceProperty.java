package com.timurisachenko.springliquidbasemultitenancydemo.property;

@lombok.Data
public class DataSourceProperty {

    private String tenantId;
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties liquibase;
}