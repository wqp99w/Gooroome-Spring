# 사용자의 선호와 현재 위치, 날씨에 따른 음식 추천 애플리케이션 - Spring Boot

2024.03-2024.06


## 프런트엔드

[프런트엔드](https://github.com/wqp99w/Gooroome)


## 프로젝트 개요

애플리케이션의 백엔드 서버를 구성하기 위해 Spring Boot와 Restful API를 MVC 패턴을 이용하여 개발하였습니다.

## 개발 환경

+ JAVA, Spring Boot
+ Database : MySQL
+ IDE : InteliJ Ultimate

## 주요 기능

### [Restful API]

```java

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

```

+ 안드로이드 앱과 스프링 서버의 통신을 위해 Restful API를 사용하여 안드로이드 앱과의 호환성을 높였습니다.
  

### [Repository]

```java

public interface FoodRepository{
    List<Food> findByCate1AndCate2(String cate1, String cate2);
    List<Food> RandomfindBycate1Andcate2(String cate1, String cate2);

    List<Food> findALL();

}

```

+ 레포지토리를 이용하여 데이터 접근 로직을 레포지토리에서 처리하게 하여 유지보수성과 재사용성을 향상시켰습니다.

```java

public class JpaFoodRepository implements FoodRepository{
    private final EntityManager em;

    public JpaFoodRepository(EntityManager em) {this.em = em; }

    @Override
    public List<Food> findByCate1AndCate2(String cate1, String cate2) {
         return em.createQuery("select f from Food f where f.cate1 = :cate1 AND f.cate2 = :cate2", Food.class)
                 .getResultList();
    }

    //중략
}
```

+ JPA를 사용하여 코드의 생산성과 유지보수성을 향상 시켰습니다.
  
### [Service]

```java

@Transactional
public class FoodService {
    private final FoodRepository foodRepository;
    ///중략

    public List<Food> getAllFoods() {
        List<Food> foods = foodRepository.findALL();
        foods.forEach(food -> System.out.println("Food: " + food.getFood() + ", Category1: " + food.getCate1() + ", Category2: " + food.getCate2()));
        return foodRepository.findALL();
    }

    public List<Food> findRandomFoodByCategories(String cate1, String cate2) {
        return foodRepository.RandomfindBycate1Andcate2(cate1, cate2);
    }
}

```

+ Service 클래스를 사용하여 코드의 가독성을 높였으며, 재사용성 또한 높였습니다.



## 시연 영상

[시연영상](https://www.youtube.com/watch?v=CxD3iMuHXOE)

