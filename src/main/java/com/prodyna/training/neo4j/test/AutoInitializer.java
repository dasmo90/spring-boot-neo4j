package com.prodyna.training.neo4j.test;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class AutoInitializer {

    private final PersonRepository personRepository;

    public AutoInitializer(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void init() {

        List<String> existingPersons =
                StreamSupport.stream(personRepository.findAll().spliterator(), true)
                        .map(Person::getName)
                        .collect(Collectors.toList());

        List<Person> personsToBeCreated = Stream.of("Pascal", "Tony", "Philip", "Kay", "Kristina", "Moritz")
                .filter(person -> !existingPersons.contains(person))
                .map(name -> {
                    Person person = new Person();
                    person.setName(name);
                    return person;
                })
                .collect(Collectors.toList());

        personRepository.saveAll(personsToBeCreated);
    }
}
