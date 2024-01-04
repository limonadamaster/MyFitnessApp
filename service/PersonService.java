package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.model.Person;

import java.util.List;

public interface PersonService {
     void savePerson(Person person);
     List<Person> getAllPersons();
     Person findPerson(Long id);
     Person findPersonByName(String name);
}
