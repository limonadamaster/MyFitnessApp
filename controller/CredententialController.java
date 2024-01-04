package com.example.MyFitnessApp.Controller;

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
    @Autowired
    private CredententialService credententialServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<Credentential> createCredentential(
            @RequestParam String username,
            @RequestParam String password
    ){
        Credentential credentential = credententialServiceImpl.createCredentential(username,password);
        return new ResponseEntity<>(credentential,HttpStatus.CREATED);
    }
}
