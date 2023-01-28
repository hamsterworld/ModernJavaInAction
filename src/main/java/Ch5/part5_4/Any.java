package Ch5.part5_4;

import common.Dish;
import common.Menu;

import java.util.Optional;

public class Any {

    public void case1(){
        Optional<Dish> any = Menu.menu.stream().filter(Dish::isVegetrian).findAny();
    }

    public void case2(){
        Menu.menu.stream().filter(Dish::isVegetrian).findAny().ifPresent(System.out::println);
    }

    public void case3(){
        Optional<Dish> first = Menu.menu.stream().filter(Dish::isVegetrian).findFirst();
        System.out.println(first.get());
    }
}
