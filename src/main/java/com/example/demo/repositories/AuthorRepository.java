package com.example.demo.repositories;

import com.example.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findAllByBirthDayBetween(LocalDate birthDayMin, LocalDate birthDayMax);

    Author findAuthorByFirstNameAndLastNameAndBirthDay(String firstName, String lastName, LocalDate birthDay);

}
