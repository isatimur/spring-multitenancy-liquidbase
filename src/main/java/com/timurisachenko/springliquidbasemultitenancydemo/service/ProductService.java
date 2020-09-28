package com.timurisachenko.springliquidbasemultitenancydemo.service;

public interface ProductService {

    com.timurisachenko.springliquidbasemultitenancydemo.model.Product save(com.timurisachenko.springliquidbasemultitenancydemo.model.Product product);

    org.springframework.data.domain.Page<com.timurisachenko.springliquidbasemultitenancydemo.model.Product> findAll(org.springframework.data.domain.Pageable pageable);
}
