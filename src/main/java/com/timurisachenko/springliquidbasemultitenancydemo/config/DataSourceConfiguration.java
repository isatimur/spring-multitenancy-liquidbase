package com.timurisachenko.springliquidbasemultitenancydemo.config;

import com.timurisachenko.springliquidbasemultitenancydemo.property.DataSourceProperties;
import com.timurisachenko.springliquidbasemultitenancydemo.tenant.TenantRoutingDataSource;

@org.springframework.context.annotation.Configuration
@org.springframework.transaction.annotation.EnableTransactionManagement
@org.springframework.boot.autoconfigure.domain.EntityScan(basePackages = { "com.timurisachenko.springliquidbasemultitenancydemo" })
@org.springframework.data.jpa.repository.config.EnableJpaRepositories(basePackages = { "com.timurisachenko.springliquidbasemultitenancydemo" })
public class DataSourceConfiguration {

    @org.springframework.context.annotation.Bean(name = "dataSources")
    @org.springframework.context.annotation.Primary
    public java.util.Map<Object, Object> getDataSources(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.getDataSources().stream().map(dataSourceProperty -> {
            javax.sql.DataSource dataSource = org.springframework.boot.jdbc.DataSourceBuilder.create()
                    .url(dataSourceProperty.getUrl())
                    .username(dataSourceProperty.getUsername())
                    .password(dataSourceProperty.getPassword())
                    .driverClassName(dataSourceProperty.getDriverClassName())
                    .build();
            return new TenantIdDataSource(dataSourceProperty.getTenantId(), dataSource);
        }).collect(java.util.stream.Collectors.toMap(TenantIdDataSource::getTenantId, TenantIdDataSource::getDataSource));
    }

    @org.springframework.context.annotation.Bean(name = "tenantRoutingDataSource")
    @org.springframework.context.annotation.DependsOn("dataSources")
    public javax.sql.DataSource dataSource(java.util.Map<Object, Object> dataSources) {
        org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource tenantRoutingDataSource = new TenantRoutingDataSource();
        tenantRoutingDataSource.setTargetDataSources(dataSources);
        tenantRoutingDataSource.setDefaultTargetDataSource(dataSources.get("dasreda"));
        tenantRoutingDataSource.afterPropertiesSet();
        return tenantRoutingDataSource;
    }

    @lombok.Data
    @lombok.AllArgsConstructor
    private class TenantIdDataSource {
        private Object tenantId;
        private Object dataSource;
    }
}
