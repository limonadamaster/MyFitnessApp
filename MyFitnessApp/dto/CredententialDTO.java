package com.example.MyFitnessApp.dto;

public class CredententialDTO {
    private String username;

    public String getUsername() {
        return username;
    }

    public CredententialDTO(CreateCredententialDTO username) {
        this.username = username.getUsername();
    }
}
