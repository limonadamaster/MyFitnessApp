package com.example.MyFitnessApp.service;

import com.example.MyFitnessApp.model.Food;

import java.util.List;

public interface FoodService {
    Food addFood(Food food);

    List<Food> getFoods();
}
