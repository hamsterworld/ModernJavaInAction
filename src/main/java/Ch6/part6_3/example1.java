package Ch6.part6_3;

import common.Dish;
import common.Menu;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * 꼭 사용법을 알아두어야할것들 [ABC]
 * Map 과 굉장히 관련이 깊은거 같기도하고
 */
public class example1 {

    public enum CaloricLeve{
        DIET,NORMAL,FAT
    }

    // 기본값은 Map key,value value 는 List 인듯?
    public void case1(){
        Map<Dish.Type, List<Dish>> map = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(map);
    }

    public void case2(){
        Map<CaloricLeve, List<Dish>> collect1 = Menu.menu.stream().collect(
                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLeve.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLeve.NORMAL;
                    else return CaloricLeve.FAT;
                })
        );
        System.out.println(collect1);
    }

    // 700 칼로리만 넘는 요리만 필터해보자.
    // 문제점 700이 넘는애들중에 만족하는애가 MEAT 뿐이라 MEAT 만 나온다.
    public void case3(){
        Map<Dish.Type, List<Dish>> collect = Menu.menu.stream().filter(dish -> dish.getCalories() > 700).collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect);
    }

    // 이것이 바로 [groupingBy] 의 힘이다.
    /*
        groupingBy 에서
        첫번째 인자는 말그대로 분류체계이다.
        두번째 인자는 첫번째로 분류했던 애들로 다시한번 filtering,comparator,reducing,mapping 등을 행해줄수있다.
     */
    public void case4(){
        Map<Dish.Type, List<Dish>> collect = Menu.menu.stream().
                collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.filtering(dish -> dish.getCalories() > 700, Collectors.toList())));
        System.out.println(collect);
    }

    // 각 List 를 이름별로만 뽑아내기
    // mapping(나타낼 형식,나타낼 컬렉션형식(List,Set,..))
    public void case5(){
        Map<Dish.Type, List<String>> collect = Menu.menu.stream().
                collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println(collect);
    }

    // flatMap 사용
    // flatMap 을 잘보면 stream<List<String>> 으로 나온것을 stream<String> 으로 평탄화한다.
    public void case6(){
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork",asList("greasy","salty"));
        dishTags.put("beef",asList("salty","roasted"));
        dishTags.put("chicken",asList("fried","crisp"));
        dishTags.put("french fries",asList("greasy","fried"));
        dishTags.put("rice",asList("light","natural"));
        dishTags.put("season fruit",asList("fresh","natural"));
        dishTags.put("pizza",asList("tasty","salty"));
        dishTags.put("prawns",asList("tasty","roasted"));
        dishTags.put("salmon",asList("delicious","fresh"));

        // flatMap 을 잘보면 stream<List<String>> 으로 나온것을 stream<String> 으로 평탄화한다.
        Map<Dish.Type, Set<String>> collect = Menu.menu.stream().
                collect(Collectors.groupingBy(Dish::getType, Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(), Collectors.toSet())));

        System.out.println(collect);
    }

    // 다수준 그룹화
    public void case7(){
        //첫번째 수준의 분류함수            // 두번째 수준의 분류함수
        Map<Dish.Type, Map<CaloricLeve, List<Dish>>> collect =
                Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLeve.DIET;
            else if (dish.getCalories() <= 700) return CaloricLeve.NORMAL;
            else return CaloricLeve.FAT;
        })));

        // 맨마지막 List<String> 내가 응용해본것
        Map<Dish.Type, Map<CaloricLeve, List<String>>> collect1 = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLeve.DIET;
            else if (dish.getCalories() <= 700) return CaloricLeve.NORMAL;
            else return CaloricLeve.FAT;
        }, Collectors.mapping(Dish::getName, Collectors.toList()))));

        System.out.println(collect);
        System.out.println(collect1);
    }

    // 서브그룹으로 데이터 수집
    // 각 타입별로 몇개있는지 확인가능
    public void case8(){
        Map<Dish.Type, Long> collect = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect);
    }

    // 각 타입별 가장 높은 칼로리를 가진 요리를 찾기
    public void case9(){
        Map<Dish.Type, Optional<Dish>> collect = Menu.menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));

        System.out.println(collect);
    }

    // Optional 을 변환해보자
    // 즉, 컬렉터 결과에 다른형식을 적용해보자. collectingAndThen
    // [collectingAndThen]
    public void case10(){

        Map<Dish.Type, Dish> collect = Menu.menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));

        System.out.println(collect);

        Map<Dish.Type, String> collect1 = Menu.menu.stream().collect(
                Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),optional -> optional.get().getName()
                )));

        System.out.println(collect1);
    }


    public void case11(){
        Map<Dish.Type, Integer> collect = Menu.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
        System.out.println(collect);
    }

    public void case12(){
        Map<Dish.Type, Set<CaloricLeve>> collect = Menu.menu.stream().
                collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLeve.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLeve.NORMAL;
                    else return CaloricLeve.FAT;
                }, Collectors.toSet())));

        System.out.println(collect);


        Map<Dish.Type, Set<CaloricLeve>> collect1 = Menu.menu.stream().
                collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLeve.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLeve.NORMAL;
                    else return CaloricLeve.FAT;
                }, Collectors.toCollection(HashSet::new))));

        System.out.println(collect1);
    }

    // 분할
    public void case13(){
        Map<Boolean, List<Dish>> collect =
                Menu.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetrian));
        System.out.println(collect);

        List<Dish> dishes = collect.get(true);
        System.out.println(dishes);

        // 이것도 가능하긴함
        List<Dish> collect1 = Menu.menu.stream().filter(Dish::isVegetrian).collect(Collectors.toList());
        System.out.println(collect1);
    }

    public static void main(String[] args) {
        example1 example1 = new example1();
        example1.case1();
        example1.case2();
        example1.case3();
        example1.case4();
        example1.case5();
        example1.case6();
        example1.case7();
        example1.case8();
        example1.case9();
        example1.case10();
        example1.case11();
        example1.case12();
    }
}
