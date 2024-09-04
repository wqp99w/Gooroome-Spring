package com.example.demo.Food.controller;

import com.example.demo.Food.domain.Food;
import com.example.demo.Food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/categoris")
    public List<Food> findFoodByCategories(String cate1, String cate2) {
        return foodService.findRandomFoodByCategories(cate1, cate2);
    }
}

