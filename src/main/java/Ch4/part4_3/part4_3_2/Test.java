package Ch4.part4_3.part4_3_2;

import Ch4.common.Dish;
import Ch4.common.Menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 외부반복은 명시적으로 컬렉션에서 요소하나를 가져와서 하나씩 처리해야한다!
 *
 * 내부반복의 장점
 * 1. 명시적 반복을 사용하지않고 바로 모든 menu 의 이름을 담아주세요 라고할수있다.
 * ex) menu 를 하나씩 꺼내서 있으면 getName 해서 list 에 넣어주세요~ 라고 안한다. 가독성 up
 * 결국, 자바8 에서 반복자가없는 것들이 필요했고 그로인해 스트림이 생겨났다.
 *
 * 2. 내부반복을 사용하면 병렬처리나 최적화에 유리하다 -> 나중에 배우게될지도?
 */
public class Test {

    // for-each 를 통한 외부 반복
    public void test1(){
        List<String> list = new ArrayList<>();
        List<Dish> menu = Menu.menu;
        for (Dish dish : menu) { // <-- 명시적 반복
            list.add(dish.getName());
        }
    }

    // 반복자를 사용한 외부 반복
    public void test2(){
        List<String> list = new ArrayList<>();
        Iterator<Dish> iterator = Menu.menu.iterator();
        while (iterator.hasNext()){ // <-- 명시적 반복
            Dish dish = iterator.next();
            list.add(dish.getName());
        }
    }

    // 스트림 내부 반복 , 반복자를 사용하지않는다.
    public void test3(){
        List<String> list = Menu.menu.stream().map(Dish::getName).collect(Collectors.toList());
    }
}
