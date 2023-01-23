package Ch2.behavior_parameterization.step2;


import Ch2.behavior_parameterization.step2.step2.Color;

import java.util.ArrayList;
import java.util.List;


public class step2 {

    public enum Color{
        RED,GREEN;
    }

    public static List<Apple> filterApples(List<Apple> inventory,Color color,int weight,boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if((flag && apple.getColor().equals(color))){
                if(!flag && apple.getWeight() > weight){
                    result.add(apple);
                }
            }
        }
        return result;
    }

    // 위와같은 코드는 정말형편없다.
    // 1. client 가 flag 인 true,false 가 뭔지 직감적으로 이해하기가 너무힘들다.
    // 2. 요구사항이 추가되거나 변경되었을때도 유연하게 대응할수없다.

    // 동작의 파라미터화가 절실한상황이다.

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