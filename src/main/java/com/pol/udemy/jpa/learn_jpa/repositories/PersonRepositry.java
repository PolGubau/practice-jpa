package com.pol.udemy.jpa.learn_jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pol.udemy.jpa.learn_jpa.dto.PersonDto;
import com.pol.udemy.jpa.learn_jpa.entities.Person;

public interface PersonRepositry extends CrudRepository<Person, Long> {

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p.name, p.lastname from Person p")
    List<Object[]> obtainPersonalValues();

    @Query("select new com.pol.udemy.jpa.learn_jpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> getALlPersonDto();
}
