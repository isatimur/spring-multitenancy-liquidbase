package com.timurisachenko.springliquidbasemultitenancydemo.service;

@org.springframework.stereotype.Service
@lombok.AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final com.timurisachenko.springliquidbasemultitenancydemo.repository.UserRepository userRepository;

    @Override
    public com.timurisachenko.springliquidbasemultitenancydemo.model.User save(com.timurisachenko.springliquidbasemultitenancydemo.model.User user) {
        return this.userRepository.save(user);
    }

    @Override
    public org.springframework.data.domain.Page<com.timurisachenko.springliquidbasemultitenancydemo.model.User> findAll(org.springframework.data.domain.Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }
}
