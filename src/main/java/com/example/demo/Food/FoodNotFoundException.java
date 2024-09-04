package com.example.demo.Food;

public class FoodNotFoundException extends RuntimeException {

    public FoodNotFoundException(String cate1, String cate2) {
        super(String.format("Food not found with cate1: %s and cate2: %s", cate1, cate2));
    }
}