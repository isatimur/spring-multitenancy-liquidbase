package com.timurisachenko.springliquidbasemultitenancydemo.controller;

import com.timurisachenko.springliquidbasemultitenancydemo.model.User;
import com.timurisachenko.springliquidbasemultitenancydemo.service.UserService;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/user")
@lombok.AllArgsConstructor
public class UserController {

    private final UserService userService;

    @org.springframework.web.bind.annotation.PostMapping
    public User save(@org.springframework.web.bind.annotation.RequestBody User user) {
        return this.userService.save(user);
    }

    @org.springframework.web.bind.annotation.GetMapping
    public org.springframework.data.domain.Page<User> findAll(@org.springframework.web.bind.annotation.RequestParam(defaultValue = "0", required = false) Integer page,
                                                              @org.springframework.web.bind.annotation.RequestParam(defaultValue = "10", required = false) Integer size) {
        return this.userService.findAll(org.springframework.data.domain.PageRequest.of(page, size));
    }
}