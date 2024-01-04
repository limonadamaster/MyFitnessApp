package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.model.CalorieIntake;

import java.time.LocalDate;
import java.util.List;

public interface CalorieIntakeService {
    public void addCalorieIntakeForDay(String firstName , String foodName);
    public List<CalorieIntake> getMeal(String person, LocalDate date);
}
