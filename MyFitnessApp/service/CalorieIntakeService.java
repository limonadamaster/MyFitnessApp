package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.dto.CalorieIntakeDTO;
import com.example.MyFitnessApp.model.CalorieIntake;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

public interface CalorieIntakeService {
     HttpStatus addCalorieIntakeForDay(String userName , String foodName, float servingSize);
     List<CalorieIntakeDTO> getMeal(String person, LocalDate date);

}
