package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.model.Credentential;
import com.example.MyFitnessApp.repository.CredententialRepository;
import com.example.MyFitnessApp.service.CredententialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredententialServiceImpl implements CredententialService {
    @Autowired
    private CredententialRepository credententialRepository;
@Override
    public Credentential createCredentential(String username,String password){
        //make new one
        Credentential credentential = new Credentential();
        credentential.setUsername(username);
        credentential.setPassword(password);

        //save to database
        return credententialRepository.save(credentential);
    }
}
