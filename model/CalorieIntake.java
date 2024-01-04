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
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private int totalCalories;

    public int getTotalCalories() {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public CalorieIntake() {
    }

    public CalorieIntake(Long id, LocalDate intakeDate, Person person, Food food) {
        this.id = id;
        this.intakeDate = intakeDate;
        this.person = person;
        this.food = food;
    }

    @Override
    public String toString() {
        return "CalorieIntake{" +
                "id=" + id +
                ", intakeDate=" + intakeDate +
                ", person=" + person +
                ", food=" + food +
                ", totalCalories=" + totalCalories +
                '}';
    }
}
