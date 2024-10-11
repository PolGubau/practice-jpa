package com.pol.udemy.jpa.learn_jpa.services;

import java.util.List;

import com.pol.udemy.jpa.learn_jpa.dto.PersonDto;
import com.pol.udemy.jpa.learn_jpa.entities.Person;

public interface PersonService {
    List<Person> getByProgrammingLanguage(String programmingLanguage);

    List<Person> listAll();

    Person createUser(Person person);

    List<PersonDto> getALlPersonDto();

    void deleteAll();

    void delete(Long id);
}
