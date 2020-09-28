package com.timurisachenko.springliquidbasemultitenancydemo.repository;

@org.springframework.stereotype.Repository
public interface PersonRepository extends org.springframework.data.repository.CrudRepository<com.timurisachenko.springliquidbasemultitenancydemo.model.Person, Long> {
    @org.springframework.data.jpa.repository.Query("Select name from Person p WHERE p.name LIKE %:personName%")
    String findByName(String personName);
}
