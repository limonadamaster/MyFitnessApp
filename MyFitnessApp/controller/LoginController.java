package com.example.MyFitnessApp.controller;

import com.example.MyFitnessApp.dto.LoginDTO;
import com.example.MyFitnessApp.service.implementation.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class LoginController {

    private final LoginServiceImpl loginService;

    @Autowired
    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        if(!loginService.loginAuthentication(loginDTO.getUsername(),loginDTO.getPassword())){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid user");
        }

        return ResponseEntity.ok("Login successful");
    }

}
