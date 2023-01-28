package Ch5.part5_2;

import common.Dish;
import common.Menu;

import java.util.List;
import java.util.stream.Collectors;

public class limit {

    // limit 는 최대 n 개요소를 반환한다. 조건과 일치하는 처음 세요소를 즉시 다음결과로 반환한다.
    // limit 요소가 채워지면 더안돌고 마무리한다.
    public void case1(){
        List<Dish> collect =
                Menu.specialMenu.stream()
                        .filter(d -> {
                            System.out.println(d.getName());
                            return d.getCalories() > 300;
                        })
                        .limit(3).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void main(String[] args) {
        limit limit = new limit();
        limit.case1();
    }

}
