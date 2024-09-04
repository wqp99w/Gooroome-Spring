package com.example.demo;

import com.example.demo.Food.service.FoodService;
import com.example.demo.User.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		FoodService foodService = context.getBean(FoodService.class);
		//foodService.someMethod("일식","면");
		UserService userService = context.getBean(UserService.class);
		userService.UserPre("abcd");

	}

}

