package Ch2.behavior_parameterization.step4;



import Ch2.behavior_parameterization.step4.filterapple.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

import static Ch2.behavior_parameterization.step4.Color.RED;

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

    // 이제 매우 유연하게 동작을 파라미터화해서 사용할수있게되었다.
    // 람다식을 이용하여 좀더 간편하게 사용할수있게되었다. 이제귀찮게 interface 를 구현하고 그럴일 없다.
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Test.filterColorApples(inventory,apple -> apple.getWeight() > 150 && apple.getColor().equals(RED));
        Test.filterColorApples(inventory,apple -> apple.getWeight() > 200);
    }
}
