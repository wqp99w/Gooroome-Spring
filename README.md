# 사용자의 선호와 현재 위치, 날씨에 따른 음식 추천 애플리케이션 - Spring Boot

2024.03-2024.06


## 프로젝트 개요

애플리케이션의 백엔드 서버를 구성하기 위해 Spring Boot와 Restful API를 MVC 패턴을 이용하여 개발하였습니다.

## 개발 환경

+ JAVA, Spring Boot
+ Database : MySQL
+ IDE : InteliJ Ultimate

## 주요 기능

### [Restful API]

'''

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

'''
  

### [Repository]


  
### [Service]






* * * *

## 시연 영상
