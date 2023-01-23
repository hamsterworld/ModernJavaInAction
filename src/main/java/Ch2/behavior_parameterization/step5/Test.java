package Ch2.behavior_parameterization.step5;



import Ch2.behavior_parameterization.step5.filterapple.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static List<Apple> filterColorApples(List<Apple> inventory, ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
