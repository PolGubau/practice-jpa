package com.pol.udemy.jpa.learn_jpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pol.udemy.jpa.learn_jpa.dto.PersonDto;
import com.pol.udemy.jpa.learn_jpa.entities.Person;
import com.pol.udemy.jpa.learn_jpa.repositories.PersonRepositry;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepositry repositry;

    PersonServiceImpl(PersonRepositry repositry) {
        this.repositry = repositry;
    }

    @Override
    public List<Person> getByProgrammingLanguage(String programmingLanguage) {
        return repositry.findByProgrammingLanguage(programmingLanguage);
    }

    @Override
    public Person createUser(Person person) {
        return repositry.save(person);
    }

    @Override
    public List<Person> listAll() {
        return (List<Person>) repositry.findAll();
    }

    @Override
    public List<PersonDto> getALlPersonDto() {
        return repositry.getALlPersonDto();
    }

    @Override
    public void deleteAll() {
        repositry.deleteAll();
    }

    @Override
    public void delete(Long id) {
        repositry.deleteById(id);
    }

}
