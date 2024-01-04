package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.repository.PersonRepository;
import com.example.MyFitnessApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllPersons(){
      return personRepository.findAll();
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    public Person findPersonByName(String name){
        return personRepository.findByfirstName(name);
    }

}
