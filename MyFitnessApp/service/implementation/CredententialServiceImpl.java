package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.dto.CreateCredententialDTO;
import com.example.MyFitnessApp.dto.CredententialDTO;
import com.example.MyFitnessApp.model.Credentential;
import com.example.MyFitnessApp.repository.CredententialRepository;
import com.example.MyFitnessApp.service.CredententialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredententialServiceImpl implements CredententialService {

    private final CredententialRepository credententialRepository;

    @Autowired
    public CredententialServiceImpl(CredententialRepository credententialRepository) {
        this.credententialRepository = credententialRepository;
    }

    @Override
    public Credentential createCredentential(CreateCredententialDTO createCredententialDTO){
        //make new one
        Credentential credentential = new Credentential(createCredententialDTO);
        //save to database
        credententialRepository.save(credentential);

        return credentential;
    }
}
