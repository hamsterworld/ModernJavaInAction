package Ch5.part5_3;

import common.Dish;
import common.Menu;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class map {

    // map 은 중간에 stream 을 변환한다고 보면 편하다
    // Dish 라는 인스턴스가 오다가 map 이 getName 만 한다면 stream 이 getName 으로 변경된다.
    public void case1(){
        List<String> collect = Menu.menu.stream().map(Dish::getName).collect(toList());
        System.out.println(collect);
    }

    public void case2(){
        List<Integer> collect = Menu.menu.stream().map(dish -> dish.getName().length()).collect(toList());
        System.out.println(collect);
    }

    public void case3(){
        List<Integer> collect = Menu.menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println(collect);
    }
}
