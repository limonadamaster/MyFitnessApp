package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.dto.CalorieIntakeDTO;
import com.example.MyFitnessApp.dto.EntityDtoConverter;
import com.example.MyFitnessApp.dto.MealRequest;
import com.example.MyFitnessApp.model.CalorieIntake;
import com.example.MyFitnessApp.model.Credentential;
import com.example.MyFitnessApp.model.Food;
import com.example.MyFitnessApp.repository.CalorieIntakeRepository;
import com.example.MyFitnessApp.repository.CredententialRepository;
import com.example.MyFitnessApp.repository.FoodRepository;
import com.example.MyFitnessApp.service.CalorieIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CalorieIntakeServiceImpl implements CalorieIntakeService {

    private CalorieIntakeRepository calorieIntakeRepository;
    private FoodRepository foodRepository;
    private CredententialRepository credententialRepository;


@Autowired
    public CalorieIntakeServiceImpl(CalorieIntakeRepository calorieIntakeRepository,
                                    FoodRepository foodRepository,
                                    CredententialRepository credententialRepository) {

        this.calorieIntakeRepository = calorieIntakeRepository;
        this.foodRepository = foodRepository;
        this.credententialRepository = credententialRepository;
    }

    @Override
   public HttpStatus addCalorieIntakeForDay(MealRequest mealRequest){


        Credentential credentential= credententialRepository.findByUsername(mealRequest.getUserName());
        Food food = foodRepository.findByName(mealRequest.getFoodName());
        if(credentential.equals(null)&&food.equals(null)){
            return HttpStatus.NOT_FOUND;
        }
        LocalDate today =LocalDate.now();

        CalorieIntake calorieIntake = calorieIntakeRepository
                .findByCredentential_UsernameAndFood_NameAndIntakeDate(mealRequest.getUserName(), mealRequest.getFoodName(), today);

       if (calorieIntake != null) {
           // Update existing calorie intake for today
           calorieIntake.setTotalCalories(
                   calculateServingSize(food.getCalories(), mealRequest.getServingSize())
           );
           calorieIntakeRepository.save(calorieIntake);

       } else {
           // Create new calorie intake entry for specific day
           CalorieIntake newCalorieIntake = new CalorieIntake();
           newCalorieIntake.setCredentential(credentential);
           newCalorieIntake.setFood(food);
           newCalorieIntake.setIntakeDate(today);
           newCalorieIntake.setTotalCalories(calculateServingSize(food.getCalories(), mealRequest.getServingSize()));
           calorieIntakeRepository.save(newCalorieIntake);
   }

       return HttpStatus.OK;
}

private int calculateServingSize(float calories , float servingSize){
    return (int)(calories * servingSize);
}

@Override
public List<CalorieIntakeDTO> getMeal(String person, LocalDate date){
       List<CalorieIntake> calorieIntakes = calorieIntakeRepository.findByCredentential_UsernameAndIntakeDate(person, date);

       List<CalorieIntakeDTO>calorieIntakeDTOS = new ArrayList<>();
       for(var objects : calorieIntakes){
           calorieIntakeDTOS.add(EntityDtoConverter.convertToDto(objects,CalorieIntakeDTO.class));
       }

       return calorieIntakeDTOS;
}
}
