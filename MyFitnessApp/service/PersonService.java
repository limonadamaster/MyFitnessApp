package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.dto.PersonDTO;
import com.example.MyFitnessApp.model.Person;

import java.util.List;

public interface PersonService {
     void savePerson(Person person);
     List<PersonDTO> getAllPersons();
     Person findPerson(Long id);
     Person findPersonByName(String name);

     PersonDTO convertEntityToDto(Person person);

     Person convertDtoToEntity(PersonDTO personDto);
}
