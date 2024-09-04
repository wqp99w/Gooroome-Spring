package com.example.demo.Food.repository;

import com.example.demo.Food.domain.Food;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaFoodRepository implements FoodRepository{
    private final EntityManager em;

    public JpaFoodRepository(EntityManager em) {this.em = em; }

    @Override
    public List<Food> findByCate1AndCate2(String cate1, String cate2) {
         return em.createQuery("select f from Food f where f.cate1 = :cate1 AND f.cate2 = :cate2", Food.class)
                 .getResultList();
    }

    @Override
    public List<Food> RandomfindBycate1Andcate2(String cate1, String cate2) {
        return em.createQuery
                ("select f from Food f where f.cate1 = :cate1 AND f.cate2 = :cate2 order by rand() LIMIT 1", Food.class)
                .setParameter("cate1",cate1)
                .setParameter("cate2",cate2)
                .getResultList();
    }

    @Override
    public List<Food> findALL() {
        return em.createQuery("select f from Food f", Food.class).getResultList();
    }


}
