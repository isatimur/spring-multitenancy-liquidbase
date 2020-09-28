package com.timurisachenko.springliquidbasemultitenancydemo.controller;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("person")
class PersonController {

    private com.timurisachenko.springliquidbasemultitenancydemo.repository.PersonRepository personRepository;

    @org.springframework.web.bind.annotation.PostMapping("person")
    public String createPerson(@org.springframework.web.bind.annotation.RequestParam String name) {
        personRepository.save(new com.timurisachenko.springliquidbasemultitenancydemo.model.Person(name, "6.7"));
        return personRepository.findByName(name) + " Saved successfully!";
    }

    @org.springframework.web.bind.annotation.GetMapping("person")
    java.util.List<com.timurisachenko.springliquidbasemultitenancydemo.model.Person> getAllPersons() {
        return (java.util.List<com.timurisachenko.springliquidbasemultitenancydemo.model.Person>) personRepository.findAll();
    }
}
