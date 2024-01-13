package com.example.MyFitnessApp.controller;

import com.example.MyFitnessApp.dto.CalorieIntakeDTO;
import com.example.MyFitnessApp.model.CalorieIntake;
import com.example.MyFitnessApp.dto.MealRequest;
import com.example.MyFitnessApp.dto.MealResponse;
import com.example.MyFitnessApp.service.CalorieIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/calories")
public class CalorieIntakeController {

    private final CalorieIntakeService calorieIntakeServiceImpl;

    @Autowired
    public CalorieIntakeController(CalorieIntakeService calorieIntakeServiceImpl) {
        this.calorieIntakeServiceImpl = calorieIntakeServiceImpl;
    }

        @PostMapping("/add")
        ResponseEntity<HttpStatus> addMeal(@RequestBody MealRequest mealRequest){
                 if(!HttpStatus.OK.equals(calorieIntakeServiceImpl.addCalorieIntakeForDay(mealRequest))){
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                 }
                 //If an issue exists check enumeration of MealRequest fields are arranged 
                        return new ResponseEntity<>(HttpStatus.OK);
        }

            @GetMapping("/{userName}")
        @ResponseBody
        MealResponse getMeal(@PathVariable String userName){
            LocalDate currentDate = LocalDate.now();

            List<CalorieIntakeDTO> result = calorieIntakeServiceImpl.getMeal(userName,currentDate);
           var count= result.stream().mapToInt(item-> (int) item.getTotalCalories()).sum();

           return new MealResponse(result,count);
        }

}
