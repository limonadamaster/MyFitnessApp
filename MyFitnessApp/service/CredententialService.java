package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.dto.CreateCredententialDTO;
import com.example.MyFitnessApp.model.Credentential;

public interface CredententialService {
    Credentential createCredentential(CreateCredententialDTO createCredententialDTO);
}
