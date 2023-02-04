package Ch6.part6_4;

import common.Dish;
import common.Menu;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * partitioningBy 에 대해서 알아보자.
 * 애네도 보면 대부분 Map 이다.
 */
public class example {

    // 분할
    public void case1(){
        Map<Boolean, List<Dish>> collect =
                Menu.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetrian));
        System.out.println(collect);

        List<Dish> dishes = collect.get(true);
        System.out.println(dishes);

        // 이것도 가능하긴함
        List<Dish> collect1 = Menu.menu.stream().filter(Dish::isVegetrian).collect(Collectors.toList());
        System.out.println(collect1);
    }

    // 분할의 장점
    // 위에서 봣듯이 분할함수의 장점은 참,거짓 두가지 요소의 스트림 리스트를 모두 유지한다는 것이다.
    // case1 을 좀더 발전시켜보자.
    public void case2(){
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect = Menu.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetrian, Collectors.groupingBy(Dish::getType)));
        System.out.println(collect);
    }

    // case1 각 그룹별 가장 칼로리가 높은음식을 찾을수도있다.
    public void case3(){
        Map<Boolean, Dish> collect = Menu.menu.stream().
                collect(Collectors
                        .partitioningBy(Dish::isVegetrian, Collectors.
                                collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect);
    }

    // 어쨋든 분할은 2가지 true/false 로 나눌수있으니 훨신더 간결하고 효과적이다.

    // 숫자를 소수와 비소수로 분할하기
    public void case4(int n){
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(collect);
    }

    // non match 어떻게 쓰는거징?
    public boolean isPrime(int candidate){
        // candidate 미만의 수를 생성한다.                미만의 수로 다 나눠서 소수면 true 로 반환한다.
        return IntStream.range(2,candidate).noneMatch(i -> candidate % i == 0);
    }


    public static void main(String[] args) {
        example example = new example();
        example.case1();
        example.case2();
        example.case3();
        example.case4(12);
    }

}
