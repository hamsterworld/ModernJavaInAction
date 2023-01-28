package Ch5.part5_1;

import common.Dish;
import common.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    // 프리디케이트로 필터링
    public void case1(){
        List<Dish> list = Menu.menu.stream().filter(Dish::isVegetrian).collect(Collectors.toList());
    }

    // 고유 요소 필터링
    public void case2(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        // distinct 는 HashCode 와 Equals 로 비교한다.
        numbers.stream().filter( i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

}
