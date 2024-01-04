package com.example.MyFitnessApp.repository;

import com.example.MyFitnessApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long>{
    Person findByfirstName(String firstName);

}
