package com.example.demo.Food.repository;

import com.example.demo.Food.domain.Food;

import java.util.List;

public interface FoodRepository{
    List<Food> findByCate1AndCate2(String cate1, String cate2);
    List<Food> RandomfindBycate1Andcate2(String cate1, String cate2);

    List<Food> findALL();

}
