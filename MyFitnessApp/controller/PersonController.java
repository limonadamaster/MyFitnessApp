package com.example.MyFitnessApp.controller;

import com.example.MyFitnessApp.dto.PersonDTO;
import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personServiceImpl;

    @Autowired
    PersonController(PersonService personServiceImpl){
        this.personServiceImpl = personServiceImpl;
    }

    @PutMapping("/add")
    public void addPerson(@RequestBody Person person){
        personServiceImpl.savePerson(person);
    }

   @GetMapping("/getperson")
    public List<PersonDTO> getPersons(){
        return personServiceImpl.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id){
        Person person = personServiceImpl.findPerson(id);

        if(person!=null){
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
