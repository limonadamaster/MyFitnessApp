package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.model.Credentential;
import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.dto.RegistationInformation;
import com.example.MyFitnessApp.repository.CredententialRepository;
import com.example.MyFitnessApp.repository.PersonRepository;
import com.example.MyFitnessApp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private PersonRepository personRepository;
    private CredententialRepository credententialRepository;

    @Autowired
    public RegistrationServiceImpl(PersonRepository personRepository, CredententialRepository credententialRepository) {
        this.personRepository = personRepository;
        this.credententialRepository = credententialRepository;
    }


    public Person registerPersonWithCredentation(RegistationInformation registationInformation){
       Person person = new Person(registationInformation.getFirstName(),
                                  registationInformation.getLastName());

       Credentential credentential = new Credentential(
               registationInformation.getUsername(),
               registationInformation.getPassword(),
               person);

        credentential.setPerson(person);
       personRepository.save(person);
       credententialRepository.save(credentential);

        return person;


   }
}
