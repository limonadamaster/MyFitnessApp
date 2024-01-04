package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.model.Credentential;
import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.model.RegistationInformation;
import com.example.MyFitnessApp.repository.CredententialRepository;
import com.example.MyFitnessApp.repository.PersonRepository;
import com.example.MyFitnessApp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CredententialRepository credententialRepository;


    public Person registerPersonWithCredentation(RegistationInformation registationInformation){
       Person person = new Person(registationInformation.getFirstName(),
                                  registationInformation.getLastName());

       //When we take password (HASH)
        //String hashedPassword = passwordEncoder.encode(registationInformation.getPassword());

       Credentential credentential = new Credentential(
               registationInformation.getUsername(),
               registationInformation.getPassword(),
               person);

      // person.setCredentential(credentential);
        credentential.setPerson(person);
       personRepository.save(person);
       credententialRepository.save(credentential);
        return person;
   }
}
