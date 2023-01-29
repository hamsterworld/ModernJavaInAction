package Ch6.part6_2;

import common.Dish;
import common.Menu;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example1 {

    // 일반적인 카운팅
    public void case1(){
        Long collect = Menu.menu.stream().collect(Collectors.counting());
        long count = Menu.menu.stream().count();
    }

    // 최대값 최소값검색
    public void case2(){
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> collect = Menu.menu.stream().collect(Collectors.maxBy(dishComparator));
    }

    // 요약 연산
    public void case3(){
        Integer collect = Menu.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        Double collect1 = Menu.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        IntSummaryStatistics collect3 = Menu.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        //IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}
        System.out.println(collect3);
    }

    // 문자열 연결
    public void case4(){
        String collect = Menu.menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    // reducing 전체의 합
    public void case5(){
        Integer collect = Menu.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(collect);
    }

    // reducing 최대값 구하기
    public void case6(){
        Optional<Dish> collect = Menu.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(collect.get());
    }

    public static void main(String[] args) {
        Example1 example1 = new Example1();
        example1.case3();
        example1.case4();
        example1.case5();
        example1.case6();
    }
}
