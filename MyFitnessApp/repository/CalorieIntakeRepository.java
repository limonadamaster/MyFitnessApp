package com.example.MyFitnessApp.repository;

import com.example.MyFitnessApp.dto.CalorieIntakeDTO;
import com.example.MyFitnessApp.model.CalorieIntake;
import com.example.MyFitnessApp.model.Food;
import com.example.MyFitnessApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CalorieIntakeRepository extends JpaRepository<CalorieIntake,Long> {
    List<CalorieIntake> findByCredentential_UsernameAndIntakeDate(String person, LocalDate date);

    CalorieIntake findByCredentential_UsernameAndFood_NameAndIntakeDate(String Username, String food, LocalDate localDate);
}
