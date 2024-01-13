package com.example.MyFitnessApp.dto;

import com.example.MyFitnessApp.model.Food;
import lombok.Data;

import java.time.LocalDate;
//TO RETURN ONLY MEAL INFORMATION AND DATE
@Data
public class CalorieIntakeDTO {
    private LocalDate intakeDate;

    private Food food;

    private float totalCalories;
}
