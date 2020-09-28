package com.timurisachenko.springliquidbasemultitenancydemo.property;

@lombok.Data
@org.springframework.stereotype.Component
@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "spring")
public class DataSourceProperties {

    private java.util.List<DataSourceProperty> dataSources = new java.util.ArrayList<>();
}
