package Ch2.behavior_parameterization.step6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    // 최종 버전
    public static <T> List<T> filter(List<T> inventory, Predicate<T> applePredicate){
        List<T> result = new ArrayList<>();
        for (T item : inventory) {
            if (applePredicate.test(item)){
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Apple> appleList = new ArrayList<>();
        List<Apple> filterList = filter(appleList,a -> a.getWeight() > 150);
    }
}
