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
  

### [Repository]

```java

public interface FoodRepository{
    List<Food> findByCate1AndCate2(String cate1, String cate2);
    List<Food> RandomfindBycate1Andcate2(String cate1, String cate2);

    List<Food> findALL();

}

```

```java

public class JpaFoodRepository implements FoodRepository{
    private final EntityManager em;

    public JpaFoodRepository(EntityManager em) {this.em = em; }

    @Override
    public List<Food> findByCate1AndCate2(String cate1, String cate2) {
         return em.createQuery("select f from Food f where f.cate1 = :cate1 AND f.cate2 = :cate2", Food.class)
                 .getResultList();
    }

```

  
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




* * * *

## 시연 영상
