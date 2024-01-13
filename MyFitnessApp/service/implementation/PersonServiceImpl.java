package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.dto.EntityDtoConverter;
import com.example.MyFitnessApp.dto.PersonDTO;
import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.repository.PersonRepository;
import com.example.MyFitnessApp.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;


    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public List<PersonDTO> getAllPersons(){

        return personRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    public Person findPersonByName(String name){
        return personRepository.findByfirstName(name);
    }

    @Override
    public PersonDTO convertEntityToDto(Person person) {
        return EntityDtoConverter.convertToDto(person,PersonDTO.class);
    }

    @Override
    public Person convertDtoToEntity(PersonDTO personDto) {
        return EntityDtoConverter.convertToEntity(personDto,Person.class);
    }

}
