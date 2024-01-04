package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.model.RegistationInformation;

public interface RegistrationService {
    public Person registerPersonWithCredentation(RegistationInformation registationInformation);
}
