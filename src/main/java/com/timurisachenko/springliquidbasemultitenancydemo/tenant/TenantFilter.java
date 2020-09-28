package com.timurisachenko.springliquidbasemultitenancydemo.tenant;

public class TenantFilter extends org.springframework.web.filter.GenericFilterBean {

    @Override
    public void doFilter(javax.servlet.ServletRequest servletRequest, javax.servlet.ServletResponse servletResponse, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {

        final String X_TENANT_ID = "X-TenantID";

        final javax.servlet.http.HttpServletRequest httpServletRequest = (javax.servlet.http.HttpServletRequest) servletRequest;
        final String tenantId = httpServletRequest.getHeader(X_TENANT_ID);

        if (tenantId == null) {
            final javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) servletResponse;
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write("{\"error\": \"No tenant header supplied\"}");
            response.getWriter().flush();
            com.timurisachenko.springliquidbasemultitenancydemo.tenant.TenantContext.clear();
            return;
        }

        com.timurisachenko.springliquidbasemultitenancydemo.tenant.TenantContext.setCurrentTenant(tenantId);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
