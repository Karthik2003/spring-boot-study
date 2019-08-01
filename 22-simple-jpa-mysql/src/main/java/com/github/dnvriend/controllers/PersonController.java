package com.github.dnvriend.controllers;

import com.github.dnvriend.repositories.Person;
import com.github.dnvriend.repositories.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public List<Person> listPersons() {
        return personRepository.findAll();
    }

    @PutMapping("/person")
    public Person putPerson(@RequestBody Person person) {
        return personRepository.save(
                person.toBuilder()
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}