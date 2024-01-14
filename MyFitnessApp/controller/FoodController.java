package com.example.MyFitnessApp.controller;

import com.example.MyFitnessApp.model.Food;
import com.example.MyFitnessApp.service.FoodService;
import com.example.MyFitnessApp.service.implementation.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping ("/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PutMapping("/add")
    public Food addFood(@RequestBody Food food){
        foodService.addFood(food);
        return food;
    }

    @GetMapping("/getAll")
    public List<Food> getFoods(){
        return foodService.getFoods();
    }
}
