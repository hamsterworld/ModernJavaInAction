package Ch4.part4_4.part4_4_1;

import Ch4.common.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 왜 스트림은 중간연산과 최종연산 2가지로 나누었을까?
 */
public class Test {

    public void test1(){
        List<String> names = Menu.menu.stream()
                .filter(dish -> {
                    System.out.println("filtering : " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping : " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }
    // 중간연산은 stream 을 반환하고
    // 최종연산은 stream 외에 List,Long,void 등등 여러가지를 반환한다.
    public void test2(){
        Menu.menu.stream().forEach(System.out::println);

        long count = Menu.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();

        System.out.println(count);
    }


    // 일단은 중간연산을 다진행하고 그다음 최종연산을 진행하는 Lazy 를 한다.
    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
        test.test2();
    }
}
