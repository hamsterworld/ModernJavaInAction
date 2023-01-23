package Ch2.behavior_parameterization.step1;

import Ch2.behavior_parameterization.step1.step1.Color;

import java.util.ArrayList;
import java.util.List;

import static Ch2.behavior_parameterization.step1.step1.Color.GREEN;

public class step1 {

    enum Color{
        RED,GREEN;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    // 만약에 빨간색사과도 필터링하고싶다면? 매서드를 하나를 추가해야한다.

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