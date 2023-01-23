package Ch2.behavior_parameterization.step3;


import Ch2.behavior_parameterization.step3.step3.Color;

import java.util.ArrayList;
import java.util.List;


public class step3 {

    enum Color{
        RED,GREEN;
    }

    public static List<Apple> filterColorApples(List<Apple> inventory,Color color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    // 그러면 이번에는 무게까지 추가하고싶다면?
    // 무게와 관련된 매서드를 또 작성해야한다.

}


class Apple {

    private final Color color;
    private final int weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

}