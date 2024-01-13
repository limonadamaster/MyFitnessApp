package com.example.MyFitnessApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class MyFitnessAppApplication {


	public static void main(String[] args) {

		System.setProperty("server.port","8000");

		SpringApplication.run(MyFitnessAppApplication.class, args);
	}



}
