package Ch5.part5_3;

import common.Dish;
import common.Menu;

import java.util.List;
import java.util.stream.Collectors;

public class map {

    public void case1(){
        List<String> collect = Menu.menu.stream().map(dish -> dish.getName()).collect(Collectors.toList());
        System.out.println(collect);
    }

    public void case2(){
        List<Integer> collect = Menu.menu.stream().map(dish -> dish.getName().length()).collect(Collectors.toList());
        System.out.println(collect);
    }

    public void case3(){
        List<Integer> collect = Menu.menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(collect);
    }
}
