package Ch5.part5_2;

import common.Dish;
import common.Menu;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  java 9 에서 추가된 slicing 에 대해서 알아보자.
 */
public class slicing {

    // 일반적인 방식
    public List<Dish> case1(){
        return Menu.specialMenu.stream()
                .filter(d -> {
                    System.out.println(d.getName());
                    return d.getCalories() < 320;
                })
                .collect(Collectors.toList());
    }

    // 아래 2개 케이스는 무한스트림에서도 가능하다.
    // Menu 가 칼로리순으로 정렬되어있다는 사실에 주목하자.
    // 필터같은 경우는 전부다 조사한다.
    // 그러나 아래와같은 while 은 아니다.
    // 그래서 무한스트림에도 적용할수있다.
    // 이는 collections 크기가 큰곳에서 강력한 위력을 발휘한다.
    public List<Dish> case2(){
        return Menu.specialMenu.stream()
                .takeWhile(dish -> {
                    System.out.println(dish.getName());
                    return dish.getCalories() < 320;
                })
                .collect(Collectors.toList());
    }

    public List<Dish> case3(){
        return Menu.specialMenu.stream()
                .dropWhile(dish -> {
                    System.out.println(dish.getName());
                    return dish.getCalories() < 320;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        slicing slicing = new slicing();
        List<Dish> dishes = slicing.case1();
        System.out.println(dishes);

        List<Dish> dishes1 = slicing.case2();
        System.out.println(dishes1);

        List<Dish> dishes2 = slicing.case3();
        System.out.println(dishes2);
    }
}
