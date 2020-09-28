package com.timurisachenko.springliquidbasemultitenancydemo.service;

public interface UserService {

    com.timurisachenko.springliquidbasemultitenancydemo.model.User save(com.timurisachenko.springliquidbasemultitenancydemo.model.User user);

    org.springframework.data.domain.Page<com.timurisachenko.springliquidbasemultitenancydemo.model.User> findAll(org.springframework.data.domain.Pageable pageable);
}
