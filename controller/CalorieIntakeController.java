package com.example.MyFitnessApp.Controller;

import com.example.MyFitnessApp.model.CalorieIntake;
import com.example.MyFitnessApp.model.MealRequest;
import com.example.MyFitnessApp.service.CalorieIntakeService;
import com.example.MyFitnessApp.service.implementation.CalorieIntakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@RestController

@RequestMapping("/calories")
public class CalorieIntakeController {
    @Autowired
    private CalorieIntakeService calorieIntakeServiceImpl;

    @PostMapping("/add")
        ResponseEntity<CalorieIntakeServiceImpl> addMeal(
               @RequestBody MealRequest mealRequest
        ){
        calorieIntakeServiceImpl.addCalorieIntakeForDay(mealRequest.getFirstName(),mealRequest.getFoodName());
        return new ResponseEntity<>(HttpStatus.OK);
        }

        @GetMapping("/{firstName}")
        @ResponseBody
        List<CalorieIntake> getMeal(@PathVariable String firstName){
            LocalDate currentDate = LocalDate.now();

            List<CalorieIntake> result = calorieIntakeServiceImpl.getMeal(firstName,currentDate);

            int count=0;
            for(CalorieIntake calorieIntake:result ){
               count+= calorieIntake.getTotalCalories();
            }
            System.out.println(count);

            return result;
        }

}
