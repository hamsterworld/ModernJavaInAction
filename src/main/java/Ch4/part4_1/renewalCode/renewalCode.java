package Ch4.part4_1.renewalCode;

import Ch4.part4_1.existingCode.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자바 8의 스트림 API 의 특징
 * 1. 선언형 : 간결하고 가독성이 좋아진다.
 * 2. 조립할수있다: 유연성이 좋아진다.
 * 3. 병렬화 : 성능이 좋아진다.
 */
public class renewalCode {

    public List<String> getLowCaloricDishesName(List<Dish> menu){

        return menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparingInt(Dish::getCalories))
                // sorted 의 결과는 map 매서드에서 변환된다.
                .map(Dish::getName)
                .collect(Collectors.toList());

    }

    // 병렬수행 7장에서 자세히 알아보자.
//    public List<String> getLowCaloricDishesName(List<Dish> menu){
//
//        return menu.parallelStream()
//                .filter(d -> d.getCalories() < 400)
//                .sorted(Comparator.comparingInt(Dish::getCalories))
//                .map(Dish::getName)
//                .collect(Collectors.toList());
//
//    }
}
