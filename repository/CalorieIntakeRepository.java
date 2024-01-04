package com.example.MyFitnessApp.repository;

import com.example.MyFitnessApp.model.CalorieIntake;
import com.example.MyFitnessApp.model.Food;
import com.example.MyFitnessApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CalorieIntakeRepository extends JpaRepository<CalorieIntake,Long> {
    List<CalorieIntake> findByPerson_FirstNameAndIntakeDate(String person, LocalDate date);

    CalorieIntake findByPerson_FirstNameAndFood_NameAndIntakeDate(String person, String food, LocalDate localDate);
}
