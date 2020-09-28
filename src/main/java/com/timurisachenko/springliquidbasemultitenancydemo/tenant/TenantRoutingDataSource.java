package com.timurisachenko.springliquidbasemultitenancydemo.tenant;

public class TenantRoutingDataSource extends org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return com.timurisachenko.springliquidbasemultitenancydemo.tenant.TenantContext.getCurrentTenant();
    }
}
