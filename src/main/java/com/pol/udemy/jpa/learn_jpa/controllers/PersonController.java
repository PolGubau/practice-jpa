package com.pol.udemy.jpa.learn_jpa.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pol.udemy.jpa.learn_jpa.dto.PersonDto;
import com.pol.udemy.jpa.learn_jpa.entities.Person;
import com.pol.udemy.jpa.learn_jpa.services.PersonServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class PersonController {

    private final PersonServiceImpl service;

    PersonController(PersonServiceImpl personService) {
        this.service = personService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/p")
    public Map<String, Object> getUsers() {
        List<Person> people = service.getByProgrammingLanguage("java");

        // convert to json
        Map<String, Object> response = Map.of("people", people);

        // print
        System.out.println(response);

        // return json
        return response;
    }

    @GetMapping("/")
    public List<Person> listAll() {
        return service.listAll();
    }

    @GetMapping("/dto")
    public List<PersonDto> listAllDto(@RequestBody Person person) {
        return service.getALlPersonDto();
    }

    @PostMapping("/")
    public Person postMethodName(@RequestBody Person person) {
        return service.createUser(person);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
