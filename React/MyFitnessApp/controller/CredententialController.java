package com.example.MyFitnessApp.controller;

import com.example.MyFitnessApp.dto.CreateCredententialDTO;
import com.example.MyFitnessApp.model.Credentential;
import com.example.MyFitnessApp.service.CredententialService;
import com.example.MyFitnessApp.service.implementation.CredententialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credentential")
public class CredententialController {

    private final CredententialService credententialServiceImpl;

    @Autowired
    public CredententialController(CredententialService credententialServiceImpl) {
        this.credententialServiceImpl = credententialServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<Credentential> createCredentential(@RequestBody CreateCredententialDTO createCredententialDTO
                                                             ){
        Credentential credentential = credententialServiceImpl.createCredentential(createCredententialDTO);
        return new ResponseEntity<>(credentential,HttpStatus.CREATED);
    }
}
