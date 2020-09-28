package com.timurisachenko.springliquidbasemultitenancydemo.controller;

import com.timurisachenko.springliquidbasemultitenancydemo.model.Product;
import com.timurisachenko.springliquidbasemultitenancydemo.service.ProductService;


@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/product")
@lombok.AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @org.springframework.web.bind.annotation.PostMapping
    public Product save(@org.springframework.web.bind.annotation.RequestBody Product product) {
        return this.productService.save(product);
    }

    @org.springframework.web.bind.annotation.GetMapping
    public org.springframework.data.domain.Page<Product> findAll(@org.springframework.web.bind.annotation.RequestParam(defaultValue = "0", required = false) Integer page,
                                                                 @org.springframework.web.bind.annotation.RequestParam(defaultValue = "10", required = false) Integer size) {
        return this.productService.findAll(org.springframework.data.domain.PageRequest.of(page, size));
    }
}
