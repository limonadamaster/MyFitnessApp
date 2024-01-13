package com.example.MyFitnessApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;


@Entity
public class CalorieIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate intakeDate;

    @ManyToOne
    @JoinColumn(name = "credentential_id")
    private Credentential credentential;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private float totalCalories;

    public float getTotalCalories() {

        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(LocalDate intakeDate) {
        this.intakeDate = intakeDate;
    }

    public Credentential getCredentential() {
        return credentential;
    }

    public void setCredentential(Credentential credentential) {
        this.credentential = credentential;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public CalorieIntake() {
    }

    public CalorieIntake(Long id, LocalDate intakeDate, Credentential credentential, Food food) {
        this.id = id;
        this.intakeDate = intakeDate;
        this.credentential = credentential;
        this.food = food;
    }

    @Override
    public String toString() {
        return "CalorieIntake{" +
                "id=" + id +
                ", intakeDate=" + intakeDate +
                ", credentential=" + credentential +
                ", food=" + food +
                ", totalCalories=" + totalCalories +
                '}';
    }
}
