package com.example.MyFitnessApp.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class CreateCredententialDTO {

   private String username;
   private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CreateCredententialDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
