package com.example.MyFitnessApp.repository;

import com.example.MyFitnessApp.dto.LoginDTO;
import com.example.MyFitnessApp.model.Credentential;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.security.auth.login.CredentialException;
import java.util.Optional;

public interface CredententialRepository extends JpaRepository<Credentential,Long> {
    //boolean findBycredentential_UsernameAndcredentential_Password(String username,String password);
    Optional<LoginDTO> findByUsernameAndPassword(String username, String password);

    Credentential findByUsername(String username);


}
