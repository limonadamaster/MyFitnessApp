package com.example.MyFitnessApp.dto;
//I use this class to return List for meal in specific data and to return total calories for this day
import com.example.MyFitnessApp.model.CalorieIntake;

import java.util.List;

public class MealResponse {
    private List<CalorieIntakeDTO> mealList;
    private float totalCaloriesForThisDay;

    // Constructors, getters, and setters

    public MealResponse(List<CalorieIntakeDTO> mealList, float totalCaloriesForThisDay) {
        this.mealList = mealList;
        this.totalCaloriesForThisDay = totalCaloriesForThisDay;
    }

    public List<CalorieIntakeDTO> getMealList() {
        return mealList;
    }

    public void setMealList(List<CalorieIntakeDTO> mealList) {
        this.mealList = mealList;
    }

    public float getTotalCaloriesForThisDay() {
        return totalCaloriesForThisDay;
    }

    public void setTotalCalories(float totalCaloriesForThisDay) {
        this.totalCaloriesForThisDay = totalCaloriesForThisDay;
    }
}
