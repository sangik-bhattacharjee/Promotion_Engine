package com.example.promotion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.promotion.controller"})
public class PromotionMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionMachineApplication.class, args);
	}

}
