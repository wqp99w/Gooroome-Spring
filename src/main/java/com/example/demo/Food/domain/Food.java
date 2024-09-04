package com.example.demo.Food.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "food")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String food;

    private String cate1;

    private String cate2;

}
