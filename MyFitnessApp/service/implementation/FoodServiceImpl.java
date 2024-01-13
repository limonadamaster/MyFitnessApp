package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.model.Food;
import com.example.MyFitnessApp.repository.FoodRepository;
import com.example.MyFitnessApp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {


    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //add food
    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }
    //get foods
    @Override
    public List<Food> getFoods() {  return foodRepository.findAll(); }

}
