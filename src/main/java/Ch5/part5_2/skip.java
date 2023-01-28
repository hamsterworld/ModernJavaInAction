package Ch5.part5_2;

import common.Dish;
import common.Menu;

import java.util.List;
import java.util.stream.Collectors;

public class skip {
    public void case1(){
        List<Dish> collect =
                Menu.menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors.toList());
        System.out.println(collect);
    }
}
