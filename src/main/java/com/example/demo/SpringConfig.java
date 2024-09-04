package com.example.demo;

import com.example.demo.Food.repository.FoodRepository;
import com.example.demo.Food.repository.JpaFoodRepository;
import com.example.demo.Food.service.FoodService;
import com.example.demo.User.repository.JpaUserRepository;
import com.example.demo.User.repository.UserRepository;
import com.example.demo.User.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public FoodRepository foodRepository(){
        return new JpaFoodRepository(em);
    }

    @Bean
    public FoodService foodService(){
        return new FoodService(foodRepository());
    }

    @Bean
    public UserRepository userRepository() { return new JpaUserRepository(em); }

    @Bean
    public UserService userService() { return new UserService(userRepository());}


}
