package com.example.MyFitnessApp.model;

public class MealRequest {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public MealRequest() {
    }

    public MealRequest(String firstName, String foodName) {
        this.firstName = firstName;
        this.foodName = foodName;
    }

    private String foodName;


}
