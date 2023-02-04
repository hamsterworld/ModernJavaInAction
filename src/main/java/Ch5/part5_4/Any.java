package Ch5.part5_4;

import common.Dish;
import common.Menu;

import java.util.Optional;

public class Any {

    public void case1(){
        Optional<Dish> any = Menu.menu.stream().filter(Dish::isVegetrian).findAny();
        System.out.println(any);
    }

    public void case2(){
        Menu.menu.stream().filter(Dish::isVegetrian).findAny().ifPresent(System.out::println);
    }

    public void case3(){
        Menu.menu.stream().filter(Dish::isVegetrian).findFirst().ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Any any = new Any();
        any.case1();
        any.case2();
        any.case3();
    }
}
