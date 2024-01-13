package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.dto.RegistationInformation;

public interface RegistrationService {
     Person registerPersonWithCredentation(RegistationInformation registationInformation);

}
