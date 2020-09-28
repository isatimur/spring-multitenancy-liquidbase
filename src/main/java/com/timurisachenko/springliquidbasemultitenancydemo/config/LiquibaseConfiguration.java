package com.timurisachenko.springliquidbasemultitenancydemo.config;

import com.timurisachenko.springliquidbasemultitenancydemo.bean.MultiTenantDataSourceSpringLiquibase;
import com.timurisachenko.springliquidbasemultitenancydemo.property.DataSourceProperties;

@org.springframework.context.annotation.Configuration
@org.springframework.boot.autoconfigure.condition.ConditionalOnProperty(prefix = "spring.liquibase", name = "enabled", matchIfMissing = true)
@org.springframework.boot.context.properties.EnableConfigurationProperties(org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties.class)
@lombok.AllArgsConstructor
public class LiquibaseConfiguration {

    private org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties properties;
    private DataSourceProperties dataSourceProperties;

    @org.springframework.context.annotation.Bean
    @org.springframework.context.annotation.DependsOn("tenantRoutingDataSource")
    public MultiTenantDataSourceSpringLiquibase liquibaseMultiTenancy(java.util.Map<Object, Object> dataSources,
                                                                      @org.springframework.beans.factory.annotation.Qualifier("taskExecutor") org.springframework.core.task.TaskExecutor taskExecutor) {
        // to run changeSets of the liquibase asynchronous
        MultiTenantDataSourceSpringLiquibase liquibase = new MultiTenantDataSourceSpringLiquibase(taskExecutor);
        dataSources.forEach((tenant, dataSource) -> liquibase.addDataSource((String) tenant, (javax.sql.DataSource) dataSource));
        dataSourceProperties.getDataSources().forEach(dbProperty -> {
            if (dbProperty.getLiquibase() != null) {
                liquibase.addLiquibaseProperties(dbProperty.getTenantId(), dbProperty.getLiquibase());
            }
        });

        liquibase.setContexts(properties.getContexts());
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        return liquibase;
    }

}
