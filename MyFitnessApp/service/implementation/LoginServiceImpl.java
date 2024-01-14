package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.dto.LoginDTO;
import com.example.MyFitnessApp.repository.CredententialRepository;
import com.example.MyFitnessApp.service.CredententialService;
import com.example.MyFitnessApp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final CredententialRepository credententialService;

    @Autowired
    public LoginServiceImpl(CredententialRepository credententialService) {
        this.credententialService = credententialService;
    }


    @Override
    public boolean loginAuthentication(String username, String password) {
        Optional<LoginDTO> optionalCredential = credententialService.findByUsernameAndPassword( username,  password);
        return optionalCredential.isPresent();
    }
}
