package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.model.Credentential;

public interface CredententialService {
    Credentential createCredentential(String username, String password);
}
