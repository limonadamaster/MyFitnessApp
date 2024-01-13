package com.example.MyFitnessApp.dto;

public class MealRequest {
    private String userName;

    private float servingSize;

    public float getServingSize() {
        return servingSize;
    }

    public void setServingSize(float servingSize) {
        this.servingSize = servingSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public MealRequest() {
    }

    public MealRequest(String userName, String foodName,float servingSize ) {
        this.userName = userName;
        this.foodName = foodName;
        this.servingSize=servingSize;
    }

    private String foodName;


}
