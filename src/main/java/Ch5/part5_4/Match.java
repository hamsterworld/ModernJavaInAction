package Ch5.part5_4;

import common.Dish;
import common.Menu;

/**
 * 검색과 매칭
 *
 * Match 애네들은 모두 스트림 쇼트서킷 = 자바의 &&,|| 과같은 연산을 보여준다.
 * 쇼트서킷이란 결과가 만족되거나 불만족되면
 * 나머지 결과에 상관없이 모든요소를 처리하지않고 연산을 끝내버린다.
 * limit 도 마찬가지 limit 가 3이면
 * 3가지 요소를 찾앗다면 나머지는 볼필요도없이 최종연산을 수행한다.
 */
public class Match {

    // 채식요리가 있는가?
    // anyMatch = 최종연산
    public void case1(){
        if(Menu.menu.stream().anyMatch(Dish::isVegetrian)){
            System.out.println(" The menu is vegetarian friendly!! ");
        }
    }

    // allMatch
    public void case2(){
        if(Menu.menu.stream().allMatch(Dish::isVegetrian)){
            System.out.println(" The menu is vegetarian friendly!! ");
        }
    }

    //nonMatch
    public void case3(){
        boolean b = Menu.menu.stream().noneMatch(d -> d.getCalories() > 1000);
    }

}
