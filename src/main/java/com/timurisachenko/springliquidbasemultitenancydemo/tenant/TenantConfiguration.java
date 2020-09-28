package com.timurisachenko.springliquidbasemultitenancydemo.tenant;

@org.springframework.context.annotation.Configuration
public class TenantConfiguration {

    @org.springframework.context.annotation.Bean
    public org.springframework.boot.web.servlet.FilterRegistrationBean dawsonApiFilter(){
        org.springframework.boot.web.servlet.FilterRegistrationBean<TenantFilter> registration = new org.springframework.boot.web.servlet.FilterRegistrationBean<>();
        registration.setFilter(new com.timurisachenko.springliquidbasemultitenancydemo.tenant.TenantFilter());
        return registration;
    }
}
