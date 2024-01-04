package com.example.MyFitnessApp.repository;

import com.example.MyFitnessApp.model.Credentential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredententialRepository extends JpaRepository<Credentential,Long> {
}
