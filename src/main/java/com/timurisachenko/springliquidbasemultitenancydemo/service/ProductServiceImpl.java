package com.timurisachenko.springliquidbasemultitenancydemo.service;

import com.timurisachenko.springliquidbasemultitenancydemo.repository.PersonRepository;

@org.springframework.stereotype.Service
@lombok.AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final com.timurisachenko.springliquidbasemultitenancydemo.repository.ProductRepository productRepository;

    public com.timurisachenko.springliquidbasemultitenancydemo.model.Product save(com.timurisachenko.springliquidbasemultitenancydemo.model.Product product) {
        return this.productRepository.save(product);
    }

    public org.springframework.data.domain.Page<com.timurisachenko.springliquidbasemultitenancydemo.model.Product> findAll(org.springframework.data.domain.Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }
}
