package com.example.MyFitnessApp.controller;

import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.dto.RegistationInformation;
import com.example.MyFitnessApp.service.RegistrationService;
import com.example.MyFitnessApp.service.implementation.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationServiceImpl;

    @Autowired
    public RegistrationController(RegistrationServiceImpl registrationServiceImpl) {
        this.registrationServiceImpl = registrationServiceImpl;
    }

    @PutMapping("/create")
    public ResponseEntity<Person> registerPerson(
            @RequestBody RegistationInformation registationInformation
    ){
        registrationServiceImpl.registerPersonWithCredentation(registationInformation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
