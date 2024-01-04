package com.example.MyFitnessApp.service.implementation;

import com.example.MyFitnessApp.model.CalorieIntake;
import com.example.MyFitnessApp.model.Food;
import com.example.MyFitnessApp.model.Person;
import com.example.MyFitnessApp.repository.CalorieIntakeRepository;
import com.example.MyFitnessApp.repository.FoodRepository;
import com.example.MyFitnessApp.repository.PersonRepository;
import com.example.MyFitnessApp.service.CalorieIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalorieIntakeServiceImpl implements CalorieIntakeService {
    @Autowired
    private CalorieIntakeRepository calorieIntakeRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
   public void addCalorieIntakeForDay(String firstName , String foodName){
       Person person = personRepository.findByfirstName(firstName);

        Food food = foodRepository.findByName(foodName);

        LocalDate today =LocalDate.now();
        CalorieIntake calorieIntake = calorieIntakeRepository
                .findByPerson_FirstNameAndFood_NameAndIntakeDate(firstName,foodName,today);

       if (calorieIntake != null) {
           // Update existing calorie intake
        calorieIntake.setTotalCalories(food.getCalories());

       } else {
           // Create new calorie intake entry
           CalorieIntake newCalorieIntake = new CalorieIntake();
           newCalorieIntake.setPerson(person);
           newCalorieIntake.setFood(food);
           newCalorieIntake.setIntakeDate(today);
           newCalorieIntake.setTotalCalories(food.getCalories());
           calorieIntakeRepository.save(newCalorieIntake);
   }
}
@Override
public List<CalorieIntake> getMeal(String person,LocalDate date){
       return calorieIntakeRepository.findByPerson_FirstNameAndIntakeDate( person, date);
}
}
