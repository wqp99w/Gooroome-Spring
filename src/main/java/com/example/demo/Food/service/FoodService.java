package com.example.demo.Food.service;


import com.example.demo.Food.domain.Food;
import com.example.demo.Food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class FoodService {

    private static final Logger log = LoggerFactory.getLogger(FoodService.class);
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    public List<Food> findFoodByCategories(String cate1, String cate2) {
        return foodRepository.findByCate1AndCate2(cate1, cate2);
    }

    public List<Food> getAllFoods() {
        List<Food> foods = foodRepository.findALL();
        foods.forEach(food -> System.out.println("Food: " + food.getFood() + ", Category1: " + food.getCate1() + ", Category2: " + food.getCate2()));
        return foodRepository.findALL();
    }

    public List<Food> findRandomFoodByCategories(String cate1, String cate2) {
        return foodRepository.RandomfindBycate1Andcate2(cate1, cate2);
    }
}
