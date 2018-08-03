package com.prodyna.training.neo4j.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/consultants")
    public Iterable<Person> consultantsAll() {
        return personRepository.findAll();
    }

    @GetMapping("/consultants/startswith")
    public Iterable<Person> consultantsWithShortName(@RequestParam("namePrefix") String namePrefix) {
        return this.personRepository.findByNameStartingWith(namePrefix);
    }
}
