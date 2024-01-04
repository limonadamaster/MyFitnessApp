package com.example.MyFitnessApp.repository;

import com.example.MyFitnessApp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
    Food findByName(String name);
}
